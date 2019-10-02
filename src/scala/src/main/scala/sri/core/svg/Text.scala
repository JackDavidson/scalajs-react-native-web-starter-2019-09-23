package sri.core.svg

import sri.core.{JSComponent, _}
import scalajsplus.macros.{FunctionObjectMacro,exclude}
import scalajsplus.{ OptDefault => NoValue, OptionalParam => OP}
import sri.universal.MergeJSObjects

import scala.scalajs.js
import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@js.native
@JSImport("react-native-svg", "Text")
object TextComponent extends JSComponent[TextProps]

trait TextProps extends js.Object {
  val x: js.UndefOr[Double] = js.undefined
  val y: js.UndefOr[Double] = js.undefined
  val fontSize: js.UndefOr[Double] = js.undefined
  val fontWeight: js.UndefOr[Double] = js.undefined
  val fontFamily: js.UndefOr[String] = js.undefined
}

object Text {
  @inline
  def apply(x: OP[Double] = NoValue,
            y: OP[Double] = NoValue,
            fontSize: OP[Double] = NoValue,
            fontWeight: OP[Double] = NoValue,
            fontFamily: OP[String] = NoValue,
            @exclude extraProps: OP[TextProps] = NoValue,
            @exclude key: String | Int = null,
            @exclude ref: js.Function1[TextComponent.type, Unit] = null)(
             children: ReactNode*)
  : ReactElement { type Instance = TextComponent.type } = {
    val props = FunctionObjectMacro()
    extraProps.foreach(v => {
      MergeJSObjects(props, v)
    })
    CreateElementJSNoInline[TextComponent.type](TextComponent,
      props.asInstanceOf[TextProps],
      key,
      ref,
      children.toJSArray)
  }
}

