package sri.core.svg

import sri.core.{JSComponent, _}
import scalajsplus.macros.{FunctionObjectMacro, exclude}
import scalajsplus.{OptDefault => NoValue, OptionalParam => OP}
import sri.universal.MergeJSObjects
import scala.scalajs.js.Dynamic.{literal => json}

import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav
import scala.scalajs.js.|
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-native-svg", "Circle")
object CircleComponent extends JSComponent[CircleProps]

trait CircleProps extends js.Object {
  val height: js.UndefOr[String] = js.undefined
  val width: js.UndefOr[String] = js.undefined
  val viewBox: js.UndefOr[String] = js.undefined
  val cx: js.UndefOr[Double] = js.undefined
  val cy: js.UndefOr[Double] = js.undefined
  val r: js.UndefOr[Double] = js.undefined
  val stroke: js.UndefOr[String] = js.undefined
  val strokeWidth: js.UndefOr[Double] = js.undefined
  val fill: js.UndefOr[String] = js.undefined
}

object Circle {

  @inline
  def apply(cx: OP[Double] = NoValue,
            cy: OP[Double] = NoValue,
            r: OP[Double] = NoValue,
            stroke: OP[String] = NoValue,
            strokeWidth: OP[Double] = NoValue,
            fill: OP[String] = NoValue,
            @exclude extraProps: OP[CircleProps] = NoValue,
            @exclude key: String | Int = null,
            @exclude ref: js.Function1[CircleComponent.type, Unit] = null)(
             children: ReactNode*)
  : ReactElement { type Instance = CircleComponent.type } = {
    val props = FunctionObjectMacro()
    extraProps.foreach(v => {
      MergeJSObjects(props, v)
    })
    CreateElementJSNoInline[CircleComponent.type](CircleComponent,
      props.asInstanceOf[CircleProps],
      key,
      ref,
      children.toJSArray)
  }

}

object CircleC {

  @inline
  def apply(children: ReactNode*) =
    CreateElementJSNoInline[CircleComponent.type](CircleComponent,
      json().asInstanceOf[CircleProps],
      children = children.toJSArray)
}