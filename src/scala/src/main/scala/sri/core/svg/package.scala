package sri.core

import org.myproject.macros.reactClass

package object svg {
  // this trait is only so that intellij doesn't complain - its entirely unnecessary
  trait HasChildren {def apply(children: ReactNode*): ReactNode}
  // same deal with the defaults of = null, they are entirely ignored by the @reactClass macro
  @reactClass case class Svg(height: String = null,
                             width: String = null,
                             viewBox: String = null) extends HasChildren
  @reactClass case class Circle(height: String = null,
                                width: String = null,
                                viewBox: String = null,
                                cx: Double = null,
                                cy: Double = null,
                                r: Double = null,
                                stroke: String = null,
                                strokeWidth: Double = null,
                                fill: String = null,
                                onPress: () => _ = null) extends HasChildren
  @reactClass case class Rect(height: Double = null,
                                width: Double = null,
                                viewBox: Double = null,
                                x: Double = null,
                                y: Double = null,
                                ry: Double = null,
                                stroke: String = null,
                                strokeWidth: Double = null,
                                fill: String = null,
                                onPress: () => _ = null) extends HasChildren
  @reactClass case class Text(x: Double = null,
                              y: Double = null,
                              ry: Double = null,
                              fontSize: Double = null,
                              fontWeight: Double = null,
                              fontFamily: String = null,
                              onPress: () => _ = null) extends HasChildren
}