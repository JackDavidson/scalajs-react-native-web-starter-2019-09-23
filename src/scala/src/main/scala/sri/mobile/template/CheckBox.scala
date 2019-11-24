package sri.mobile.template

import sri.core.svg.{Path, Rect, Svg, Text}
import sri.core.{Component, CreateElement, ReactScalaClass}
import sri.universal.components.{TouchableOpacity, View}

import scala.scalajs.js.Dynamic.literal

// scale = 1.0 will give you a height of 50 and width of <character count> * 18.285714d + (2 * 18.285714d)
class CheckBox extends Component[CheckBox.Props, CheckBox.State] with ReactScalaClass {
  def render = {
    val strokeWidth = 2d * props.scale
    val height = 20d * props.scale
    val width = 20d * props.scale
    val scaleFactor = 20d * props.scale
    val widthUnit = width/100d
    val heightUnit = height/100d
    //${heightUnit*50}c${widthUnit*1}
    val secondPoint = s"${widthUnit*25d} ${heightUnit*45d}"
    val thirdPoint = s"${widthUnit*40d}-${heightUnit*85d}"

    View(style=literal(flexDirection="row", justifyContent="center", alignItems="center"))(Svg(
      height=s"${height}",
      width=s"${width}",
      viewBox=s"0 0 ${width} ${height}")(
      Path(
        d=s"M5.901 ${heightUnit*50}c${.123*scaleFactor} ${.079*scaleFactor} ${.21*scaleFactor} ${.19*scaleFactor} ${secondPoint} ${.196*scaleFactor}-${.50*scaleFactor} ${.30*scaleFactor}-${.6685*scaleFactor} ${thirdPoint}",
        fill="none",
        stroke="#000",
        strokeWidth = strokeWidth
      )()
    ))
  }
}

object CheckBox {
  case class Props(checked: Boolean,
                   scale: Double = 1d)
  case class State()
  def apply(props: Props) = CreateElement[CheckBox](props)
}

