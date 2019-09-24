import React from "react";
import MenuButton from "../Util/MenuButton";
import assets from "../Assets";
import Elm from "../Util/Elm";

export default class LowerMenu extends React.Component {
  constructor(props) {
    super(props)
    this.state = {activeMenu: "none"}
  }
  render() {
    const toDisplay = [assets.redo, assets.undo, assets.dots]
    const spaceBetweenComponents = (this.props.screenWidth - toDisplay.map(a => a.width * this.props.scale).reduce((a,b) => a + b))  / (1 + toDisplay.length)
    var posSoFar = spaceBetweenComponents
    const positions = toDisplay.map(a => {
      const result = posSoFar
      posSoFar += (a.width * this.props.scale + spaceBetweenComponents)
      return result
    })

    return (
      <Elm>
        <MenuButton
          style={{...dynamicStyles.normalButton,
            top: this.props.screenHeight - assets.buttonHeights * this.props.scale,
            left: positions[0],
            width: assets.redo.width * this.props.scale,
            height: assets.buttonHeights * this.props.scale,
            position: 'absolute'}}
          resizeMode={"contain"}
          source={assets.undo.src}
        />
        <MenuButton
          style={{...dynamicStyles.normalButton,
            top: this.props.screenHeight - assets.buttonHeights * this.props.scale,
            left: positions[1],
            width: assets.redo.width * this.props.scale,
            height: assets.buttonHeights * this.props.scale,
            position: 'absolute'}}
          resizeMode={"contain"}
          source={assets.redo.src}
        />
        <MenuButton
          style={{...dynamicStyles.normalButton,
            top: this.props.screenHeight - assets.buttonHeights * this.props.scale,
            left: positions[2],
            width: assets.redo.width * this.props.scale,
            height: assets.buttonHeights * this.props.scale,
            position: 'absolute'}}
          resizeMode={"contain"}
          onPress={() => this.setState({activeMenu: this.state.activeMenu === "dots" ? "none" : "dots"})}
          source={assets.dots.src}
        />
        {this.state.activeMenu === "dots" && <MenuButton
          style={{...dynamicStyles.normalButton,
            top: this.props.screenHeight - (assets.buttonHeights * this.props.scale * 2),
            left: positions[2] - (assets.sizing.width - assets.dots.width)* this.props.scale/2,
            width: assets.sizing.width * this.props.scale,
            height: assets.buttonHeights * this.props.scale,
            position: 'absolute'}}
          resizeMode={"contain"}
          source={assets.sizing.src}
        />}
      </Elm>
    )
  }
}

const dynamicStyles = {
  normalButton: {
    position: "absolute"
  }
}















