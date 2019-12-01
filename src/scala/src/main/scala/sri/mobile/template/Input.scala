package sri.mobile.template

import sri.core.{Component, ComponentP, CreateElement, ReactElement, ReactNode, ReactScalaClass}
import sri.mobile.template.components.{Action, TextEntryChangeAction, TopLevelReactComponent}
import sri.universal.components.TextInput

import scala.scalajs.js.Dynamic.literal

class Input extends ComponentP[Input.Props] with ReactScalaClass {
  override def render(): ReactNode = TextInput(
    style = literal(height=40, width=props.width, top=props.top, position="absolute", borderColor="gray", borderWidth=1),
    value = props.text,
    onChangeText = (t: String) => props.dispatch(TextEntryChangeAction(t))
  )
}

object Input {
  case class Props(dispatch: Action => Unit, top: Double, width: Double, text: String)
  def apply(props: Props): ReactElement = CreateElement[Input](props)
}
