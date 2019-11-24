package sri.mobile.template

import sri.core.{Component, CreateElement, CreateElementSF, ReactElement, ReactScalaClass}
import sri.universal.components.{Image, Text, View}

import scala.scalajs.js
import js.Dynamic.literal

class TodoEntry extends Component[TodoEntry.Props, TodoEntry.State] with ReactScalaClass {
  def render = View(style = literal(flexDirection="row"))(
    CheckBox(CheckBox.Props(
      scale = 1.0,
      checked = true
    )),
    Text(
      style=literal(
        position="relative",
        fontSize=props.fontSize,
        fontFamily="Courier New",
      )
    )(props.text)
  )
}

object TodoEntry {
  case class Props(top: Double = 0, left: Double = 0, fontSize: Double = 15, text: String = "")
  case class State()
  def apply(props: Props) = CreateElement[TodoEntry](props)
}