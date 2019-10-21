package sri.mobile.template

import sri.core.ReactNode
import sri.mobile.template.components.TopLevelReactComponent
import sri.universal.components.View

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("MyScalajsTopLevelComponent")
class MyScalajsTopLevelComponent(os: String, width: Double, height: Double) {
  @JSExport
  def render(): ReactNode = TopLevelReactComponent(TopLevelReactComponent.Props(width, height))
}
