package sri.core.svg

import sri.core.{JSComponent, _}
import scalajsplus.macros.{FunctionObjectMacro,exclude}
import scalajsplus.{ OptDefault => NoValue, OptionalParam => OP}
import sri.universal.MergeJSObjects

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@js.native
@JSImport("react-native-svg", "Svg")
object SvgComponent extends JSComponent[SvgProps]

trait SvgProps extends js.Object {
  val height: js.UndefOr[String] = js.undefined
  val width: js.UndefOr[String] = js.undefined
  val viewBox: js.UndefOr[String] = js.undefined
}

object Svg {

  @inline
  def apply(height: OP[String] = NoValue,
            width: OP[String] = NoValue,
            viewBox: OP[String] = NoValue,
            @exclude extraProps: OP[SvgProps] = NoValue,
            @exclude key: String | Int = null,
            @exclude ref: js.Function1[SvgComponent.type, Unit] = null)(
             children: ReactNode*)
  : ReactElement { type Instance = SvgComponent.type } = {
    val props = FunctionObjectMacro()
    extraProps.foreach(v => {
      MergeJSObjects(props, v)
    })
    CreateElementJSNoInline[SvgComponent.type](SvgComponent,
      props.asInstanceOf[SvgProps],
      key,
      ref,
      children.toJSArray)
  }

}

object SvgC {

  @inline
  def apply(children: ReactNode*) =
    CreateElementJSNoInline[SvgComponent.type](SvgComponent,
      json().asInstanceOf[SvgProps],
      children = children.toJSArray)
}

