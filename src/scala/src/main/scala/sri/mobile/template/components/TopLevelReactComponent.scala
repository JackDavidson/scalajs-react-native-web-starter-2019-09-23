package sri.mobile.template.components

import sri.core.{Component, ComponentP, ComponentS, CreateElement, CreateElementNoPropsWithChildren, CreateElementWithChildren}
import sri.mobile.template.{AddNewTodoBtn, TodoEntry}
import sri.universal.components.{ScrollView, TextInput, View}

import scala.scalajs.js.Dynamic.literal

class TopLevelReactComponent extends Component[TopLevelReactComponent.Props, TopLevelReactComponent.State] {
  initialState(TopLevelReactComponent.State(todoEntries = Seq()))
  def render() = {
    val buttonHeight = 50
    val textInputHeight = 40
    val btnTextInputSpacing = 10
    View()(
      Seq(ScrollView(style = literal(
        //backgroundColor="pink",
        //marginHorizontal=20,
        height=props.height - buttonHeight - textInputHeight - btnTextInputSpacing
      ))(
      state.todoEntries.map(entry =>
        TodoEntry(TodoEntry.Props(fontSize=30, text=entry.data))
      ): _*)) ++
      Seq(AddNewTodoBtn(AddNewTodoBtn.Props(
        top = props.height - 50,
        left = props.width / 2 - AddNewTodoBtn.widthWithScale(1, 7) / 2,
        onPress = () => {
          println("clicked v3!");
          setState((state: TopLevelReactComponent.State) => state.copy(
            todoEntries = state.todoEntries :+ TopLevelReactComponent.TodoEntry(data = state.addNewText),
            addNewText = ""
          ))
        }
      )),
      TextInput(
        style = literal(height=40, width=props.width, top=props.height - buttonHeight - textInputHeight - btnTextInputSpacing, position="absolute", borderColor="gray", borderWidth=1)
        , onChangeText = (t: String) => setState((state: TopLevelReactComponent.State) => state.copy(
          addNewText = t
        )))
    ): _*)
  }
}

object TopLevelReactComponent {
  case class TodoEntry(data: String, checked: Boolean = false)
  case class State(todoEntries: Seq[TodoEntry], addNewText: String = "")
  case class Props(width: Double, height: Double)
  def apply(props: Props) = CreateElement[TopLevelReactComponent](
    props = props,
    key = "0")
}
