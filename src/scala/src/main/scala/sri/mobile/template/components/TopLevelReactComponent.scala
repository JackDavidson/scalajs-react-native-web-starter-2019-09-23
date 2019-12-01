package sri.mobile.template.components

import sri.core.{Component, CreateElement, ReactNode}
import sri.mobile.template.{AddNewTodoBtn, Input, TodoEntry}
import sri.universal.components.{ScrollView, TextInput, View}

import scala.scalajs.js.Dynamic.literal

// the list of flux 'actions'
class Action()
case class TextEntryChangeAction(text: String) extends Action
case class AddTodoEntryAction(text: String) extends Action

// the flux store is a series of case classes. i take a little different approach here from classic flux.
// Its more like MVC, with one model where flux normally has more than one
case class Store(todoEntries: Seq[TodoEntryStore], addNewText: String = "")
case class TodoEntryStore(data: String, checked: Boolean = false)

class TopLevelReactComponent extends Component[TopLevelReactComponent.Props, Store] {
  initialState(Store(todoEntries = Seq()))
  def dispatch(event: Action): Unit = {
    println("dispatched.")
    setState((state: Store) =>
      event match {
        case TextEntryChangeAction(text) => state.copy(
          addNewText = text
        )
        case AddTodoEntryAction(text) => state.copy(
          todoEntries = state.todoEntries :+ TodoEntryStore(data = text),
          addNewText = ""
        )
      }
    )
  }
  def render(): ReactNode = {
    val buttonHeight = 50
    val textInputHeight = 40
    val btnTextInputSpacing = 10
    View()(
      Seq(ScrollView(style = literal(
        height=props.height - buttonHeight - textInputHeight - btnTextInputSpacing
      ))(
      state.todoEntries.map(entry =>
        TodoEntry(TodoEntry.Props(fontSize=30, text=entry.data))
      ): _*)) ++
      Seq(AddNewTodoBtn(AddNewTodoBtn.Props(
        top = props.height - 50,
        left = props.width / 2 - AddNewTodoBtn.widthWithScale(1, 7) / 2,
        onPress = () => dispatch(AddTodoEntryAction(state.addNewText))
      )),
      Input(Input.Props(
        dispatch = dispatch
        , top=props.height - buttonHeight - textInputHeight - btnTextInputSpacing
        , width=props.width
        , text = state.addNewText
      ))
    ): _*)
  }
}

object TopLevelReactComponent {
  case class Props(width: Double, height: Double)
  def apply(props: Props) = CreateElement[TopLevelReactComponent](
    props = props,
    key = "0")
}
