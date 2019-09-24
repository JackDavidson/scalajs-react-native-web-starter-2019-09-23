package sri.mobile.template

import sri.core.{CreateElementSF, ReactClass, ReactElement}

class RBoilerp[C <: ReactClass, P](func: P => ReactElement { type Instance = C }) {
  def apply(props: P) = CreateElementSF(func, props)
}


