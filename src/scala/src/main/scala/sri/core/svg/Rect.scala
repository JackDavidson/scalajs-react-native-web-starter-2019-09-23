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
@JSImport("react-native-svg", "Rect")
object RectComponent extends JSComponent[RectProps]

trait RectProps extends js.Object {
  val height: js.UndefOr[Double] = js.undefined
  val width: js.UndefOr[Double] = js.undefined
  val x: js.UndefOr[Double] = js.undefined
  val y: js.UndefOr[Double] = js.undefined
  val ry: js.UndefOr[Double] = js.undefined
  val fill: js.UndefOr[String] = js.undefined
  val stroke: js.UndefOr[String] = js.undefined
  val strokeWidth: js.UndefOr[Double] = js.undefined
}

object Rect {
  @inline
  def apply(height: OP[Double] = NoValue,
            width: OP[Double] = NoValue,
            x: OP[Double] = NoValue,
            y: OP[Double] = NoValue,
            ry: OP[Double] = NoValue,
            fill: OP[String] = NoValue,
            stroke: OP[String] = NoValue,
            strokeWidth: OP[Double] = NoValue,
            @exclude extraProps: OP[RectProps] = NoValue,
            @exclude key: String | Int = null,
            @exclude ref: js.Function1[RectComponent.type, Unit] = null)(
             children: ReactNode*)
  : ReactElement { type Instance = RectComponent.type } = {
    val props = FunctionObjectMacro()
    extraProps.foreach(v => {
      MergeJSObjects(props, v)
    })
    CreateElementJSNoInline[RectComponent.type](RectComponent,
      props.asInstanceOf[RectProps],
      key,
      ref,
      children.toJSArray)
  }
}

