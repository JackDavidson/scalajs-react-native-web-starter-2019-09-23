package sri.mobile.template

import sri.core.ReactNode
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

// This shows how to export a Scala.js component. Note that JSExportTopLevel works on the internals of an object as well
// as on classes. Classes appear to react as functions which return an instance of the class.
object MyScalajsTopLevelComponent {
  val lowerMenu = LowerMenu()
}
@JSExportTopLevel("MyScalajsTopLevelComponent")
class MyScalajsTopLevelComponent(os: String, width: Double, height: Double) {
  @JSExport
  def render(): ReactNode = MyScalajsTopLevelComponent.lowerMenu(LowerMenuParams(width, height, "regular", 1.0d))
}
