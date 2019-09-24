package sri.mobile.template

import scala.language.postfixOps
import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobalScope

// This shows how to export a Scala.js component. Note that JSExportTopLevel works on the internals of an object as well
// as on classes. Classes appear to react as functions which return an instance of the class.
case class ImageSrc(src: js.Any, width: Int, height: Int)
object Assets {
  val buttonHeights = 271
  import MyAssetLoader.require
  val undo = ImageSrc(require("../undo.png"), 514, buttonHeights)
  val redo = ImageSrc(require("../redo.png"), 514, buttonHeights)
  val dots = ImageSrc(require("../dots.png"), 514, buttonHeights)
  val sizing = ImageSrc(require("../sizing.png"), 610, buttonHeights)
}

// defining the javascript 'require' function, so that it is callable from scala.
@js.native
@JSGlobalScope
object MyAssetLoader extends js.Any {
  def require(path: String): js.Any = js.native
}
