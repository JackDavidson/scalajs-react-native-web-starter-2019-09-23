package sri.mobile.template

import sri.core.{Component, CreateElement, CreateElementSF, ReactElement, ReactScalaClass}
import sri.universal.components.{Image, View}
import scala.scalajs.js
import js.Dynamic.literal

object MenuVerticalAlign extends Enumeration {
  type MenuVerticalAlign = Value
  val BOTTOM = Value
}
case class MenuParams(buttons: Seq[MyButton.Props], width: Double, height: Double, scale: Double)
object staticObjs {
  val menuMaker = new RBoilerp ((p: MenuParams) => {
    val buttonWidths = p.buttons.map(_.img.width * p.scale)
    val totalWidthOfButtons = buttonWidths.reduce((a,b) => a + b)
    val availableSpace = p.width - totalWidthOfButtons
    val spaceBetweenButtons = availableSpace / (p.buttons.length + 1)
    println("total width: " + p.width)
    println("total width of btns: " + totalWidthOfButtons)
    println("total height: " + p.height)
    println("space between buttons: " + spaceBetweenButtons)
    val buttonPositions = buttonWidths.dropRight(1).scanLeft(spaceBetweenButtons)((a,b) => spaceBetweenButtons + a + b)
    View()(p.buttons.zip(buttonPositions).map(x => MyButton(x._1.copy(scale = p.scale, top = 0d, left = x._2))): _*)
  })
}

class MyButton extends Component[MyButton.Props, MyButton.State] with ReactScalaClass {
  def render() =
    Image(key = 1, sourceDynamic=props.img.src,
      style=literal(
        position="absolute",
        width=props.img.width * props.scale,
        height=props.img.height * props.scale,
        top=props.top,
        left=props.left
      )
    )
}

object MyButton {
  case class Props(img: ImageSrc, scale: Double = 0, top: Double = 0, left: Double = 0)
  case class State()
  def apply(props: Props) = CreateElement[MyButton](props)
}

case class ButtonWithImg()
case class LowerMenuParams(width: Double, height: Double, layout: String = "web", scale: Double = 1.0d)
case class LowerMenu() {
  val dots = MyButton.Props(img = Assets.dots)
  val undo = MyButton.Props(img = Assets.undo)
  val buttons = Seq(dots, undo)
  val Component = (p: LowerMenuParams) => {
    p.layout match {
      case "regular" => staticObjs.menuMaker(MenuParams(buttons, p.width, p.height, 0.20))
    }
  }
  def apply(p: LowerMenuParams): ReactElement =  CreateElementSF(Component, p)
}