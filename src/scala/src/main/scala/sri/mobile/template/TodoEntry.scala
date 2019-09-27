package sri.mobile.template

import sri.core.{Component, CreateElement, CreateElementSF, ReactElement, ReactScalaClass}
import sri.universal.components.{Image, Text, View}

import scala.scalajs.js
import js.Dynamic.literal

class TodoEntry extends Component[TodoEntry.Props, TodoEntry.State] with ReactScalaClass {
  def render =
    Text(
      style=literal(
        position="absolute",
        top=props.top,
        left=props.left,
        fontSize=props.fontSize,
        fontFamily="Courier New",
      )
    )("some text!")
}

object TodoEntry {
  case class Props(top: Double = 0, left: Double = 0, fontSize: Double = 15)
  case class State()
  def apply(props: Props) = CreateElement[TodoEntry](props)
}