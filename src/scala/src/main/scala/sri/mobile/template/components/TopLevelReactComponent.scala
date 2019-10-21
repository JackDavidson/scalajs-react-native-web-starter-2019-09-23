package sri.mobile.template.components

import sri.core.{Component, ComponentP, ComponentS, CreateElement, CreateElementNoPropsWithChildren, CreateElementWithChildren}
import sri.mobile.template.{AddNewTodoBtn, TodoEntry}
import sri.universal.components.{TextInput, View}

import scala.scalajs.js.Dynamic.literal

class TopLevelReactComponent extends Component[TopLevelReactComponent.Props, TopLevelReactComponent.State] {
  initialState(TopLevelReactComponent.State(false))
  def render() = {
    val textInput = if (state.addingNewEntry) Seq(
      TextInput(
        style = literal(height=40, width=400, top=200, position="absolute", borderColor="gray", borderWidth=1)
        /*, onChangeText = (t: String) => "asdfdsddf"*/)
    ) else Seq()
    View()(
      Seq(
      TodoEntry(TodoEntry.Props(fontSize=30, text="This is a to do entry!")),
      AddNewTodoBtn(AddNewTodoBtn.Props(
        top = if (state.addingNewEntry) props.height - 50 else props.height - 150,
        left = props.width / 2 - AddNewTodoBtn.widthWithScale(1, 7) / 2,
        onPress = () => {
          println("clicked v3!");
          setState((state: TopLevelReactComponent.State) => state.copy(addingNewEntry = true))
        }
      ))) ++ textInput: _*)
  }
}

object TopLevelReactComponent {
  case class State(addingNewEntry:Boolean)
  case class Props(width: Double, height: Double)
  def apply(props: Props) = CreateElement[TopLevelReactComponent](
    props = props,
    key = "0")
}
