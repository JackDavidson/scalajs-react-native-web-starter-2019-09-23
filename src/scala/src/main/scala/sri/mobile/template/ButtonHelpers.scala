package sri.mobile.template

import sri.core.{CreateElementSF, ReactElement}
import sri.universal.components.{Image, View}

import scala.scalajs.js
import js.Dynamic.literal

object MenuVerticalAlign extends Enumeration {
  type MenuVerticalAlign = Value
  val BOTTOM = Value
}
case class MenuParams(buttons: Seq[Button], width: Double, height: Double, scale: Double)
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
    View()(p.buttons.zip(buttonPositions).map(x => x._1(ButtonParams(p.scale, 0d, x._2))): _*)
  })
}
case class ButtonParams(scale: Double, top: Double, left: Double)
case class Button(img:  ImageSrc, onPress: () => Unit) extends RBoilerp (
  (p: ButtonParams) =>
    Image(key = 1, sourceDynamic=img.src,
      style=literal(
        position="absolute",
        width=img.width * p.scale,
        height=img.height * p.scale,
        top=p.top,
        left=p.left
      ))
)

case class LowerMenuParams(width: Double, height: Double, layout: String = "web", scale: Double = 1.0d)
case class LowerMenu() {
  val dots = Button(Assets.dots, null)
  val undo = Button(Assets.undo, null)
  val buttons = Seq(dots, undo)
  val Component = (p: LowerMenuParams) => {
    p.layout match {
      case "regular" => staticObjs.menuMaker(MenuParams(buttons, p.width, p.height, 0.20))
    }
  }
  def apply(p: LowerMenuParams): ReactElement =  CreateElementSF(Component, p)
}