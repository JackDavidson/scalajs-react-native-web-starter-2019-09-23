package sri.mobile.template

import sri.core.svg.{Circle, Rect, Svg, Text}
import sri.core.{Component, CreateElement, ReactScalaClass}
import sri.universal.components.View

import scala.scalajs.js
import scala.scalajs.js.Dynamic.literal

// scale = 1.0 will give you a height of 50 and width of <character count> * 18.285714d + (2 * 18.285714d)
class AddNewTodoBtn extends Component[AddNewTodoBtn.Props, AddNewTodoBtn.State] with ReactScalaClass {
  def render = {
    val normalFontSize = 30d
    val normalFontCharWidth = 18.285714d
    val normalFontHeight = 18d
    val fontSize = props.scale * normalFontSize
    val expectedWidthOfChar = props.scale * normalFontCharWidth
    val strokeWidth = 2d * props.scale
    val height = 50d * props.scale
    val width = (expectedWidthOfChar * props.scale * props.text.length) + (2 * expectedWidthOfChar)
    val expectedTextWidth = expectedWidthOfChar * props.text.length
    val expectedTextHeight = props.scale * normalFontHeight
    val textYPos = (height - expectedTextHeight) / 2 + expectedTextHeight
    val textXPos = (width - expectedTextWidth) / 2
    View(style=literal(
      position="absolute",
      top=props.top,
      left=props.left,
    ))(Svg(
      height=s"${height}",
      width=s"${width}",
      viewBox=s"0 0 ${width} ${height}")(
      Rect(
        width=width - strokeWidth,
        height=height - strokeWidth,
        x=strokeWidth/2,
        y=strokeWidth/2,
        ry=15d * props.scale,
        fill="#0f0",
        stroke="#000",
        strokeWidth = strokeWidth
      )(),
      Text(fontSize=fontSize,
        x=textXPos,
        y=textYPos,
        fontWeight=400d,
        fontFamily="Source Code Pro",
      )(props.text)
    ))
  }
}

object AddNewTodoBtn {
  case class Props(text: String = "Add New", top: Double = 0, left: Double = 0, scale: Double = 1d)
  case class State()
  def apply(props: Props) = CreateElement[AddNewTodoBtn](props)
  def widthWithScale(scale: Double, charCount: Int) = scale * charCount * 18.285714d + (2 * 18.285714d)
}

