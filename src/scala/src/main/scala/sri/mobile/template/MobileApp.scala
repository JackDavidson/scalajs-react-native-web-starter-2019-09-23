package sri.mobile.template

import sri.core.ReactNode
import sri.universal.components.View

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("MyScalajsTopLevelComponent")
class MyScalajsTopLevelComponent(os: String, width: Double, height: Double) {
  @JSExport
  def render(): ReactNode = View()(
    TodoEntry(TodoEntry.Props(fontSize=30)),
    LowerMenu()(LowerMenuParams(width, height, "regular", 1.0d)),
  )
}
