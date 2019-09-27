package sri.mobile.template

import sri.core.svg.{Circle, Svg}
import sri.core.{Component, CreateElement, ReactScalaClass}
import sri.universal.components.Text

import scala.scalajs.js
import scala.scalajs.js.Dynamic.literal

class AddNewTodoBtn extends Component[AddNewTodoBtn.Props, AddNewTodoBtn.State] with ReactScalaClass {
  def render =
    Svg(height="50%", width="50%", viewBox="0 0 100 100")(
      Circle(
        cx=50d,
        cy=50d,
        r=45d,
        stroke="blue",
        strokeWidth=2.5d,
        fill="green"
      )()
    )
}

object AddNewTodoBtn {
  case class Props(top: Double = 0, left: Double = 0, fontSize: Double = 15)
  case class State()
  def apply(props: Props) = CreateElement[AddNewTodoBtn](props)
}

