package org.myproject.macros

import scala.annotation.{StaticAnnotation, compileTimeOnly}
import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

object reactClass {
  def impl(c: Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
    import c.universe._

    def modifiedDeclaration(classDecl: ClassDef) = {
      val q"case class $className(..$fields) extends ..$parents { ..$body }" = classDecl
      val params = fields.asInstanceOf[List[ValDef]] map { p => p.duplicate}
      val baseName = className.toString()
      val undefOrParams = params.map(f => {
        q"""val ${f.name}: scala.scalajs.js.UndefOr[${f.tpt}] = scala.scalajs.js.undefined"""
      })
      val opParams = params.filterNot(_.name.equals("i")).map(f => {
        q"""val ${f.name}: scalajsplus.OptionalParam[${f.tpt}] = scalajsplus.OptDefault"""
      })

      c.Expr[Any](
        q"""
object ${TermName(baseName)} {
  import scala.scalajs.js.|
  import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav

  @scala.scalajs.js.native
  @scala.scalajs.js.annotation.JSImport("react-native-svg", $baseName)
  object ${TermName(baseName + "Component")} extends sri.core.JSComponent[${TypeName(baseName + "Props")}]

  trait ${TypeName(baseName + "Props")} extends scala.scalajs.js.Object {
      ..$undefOrParams
  }

  @inline
  def apply(..$opParams,
            @scalajsplus.macros.exclude extraProps: scalajsplus.OptionalParam[${TypeName(baseName + "Props")}] = scalajsplus.OptDefault,
            @scalajsplus.macros.exclude key: String | Int = null,
            @scalajsplus.macros.exclude ref: scala.scalajs.js.Function1[${TermName(baseName + "Component")}.type, Unit] = null)(
             children: sri.core.ReactNode*)
  : sri.core.ReactElement { type Instance = ${TermName(baseName + "Component")}.type } = {
    val props =  scalajsplus.macros.FunctionObjectMacro()
    extraProps.foreach(v => {
      sri.universal.MergeJSObjects(props, v)
    })
    sri.core.CreateElementJSNoInline[${TermName(baseName + "Component")}.type](${TermName(baseName + "Component")},
      props.asInstanceOf[${TypeName(baseName + "Props")}],
      key,
      ref,
      children.toJSArray)
  }
}

class ${className} {}
         """)
    }

    annottees map (_.tree) toList match {
      case (classDecl: ClassDef) :: Nil => modifiedDeclaration(classDecl)
      case x => c.abort(c.enclosingPosition, x.getClass + " is Invalid annottee")
    }
  }
}

@compileTimeOnly("enable macro paradise to expand macro annotations")
class reactClass extends StaticAnnotation {
  def macroTransform(annottees: Any*) = macro reactClass.impl
}




