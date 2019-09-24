import React from "react";
import {Dimensions, View, Platform} from "react-native";

export default class Elm extends React.Component {
  constructor(props) {
    super(props)
    const {height, width} = Dimensions.get('window');
    this.state = {height: height, width: width, top: 0}

    if (Platform.OS === 'web')
      window.addEventListener("resize", () => setTimeout(this.updateDimensions.bind(this), 50));

    Dimensions.addEventListener("change", this.updateDimensions.bind(this));
  }
  updateDimensions() {
    console.log("on layout/update dimemsions")
    const { width, height } = Dimensions.get('window');
    console.log(`width: ${width}, height: ${height}`)
    this.setState({height: height, width: width});
  }

  render() {
    return (
      <View style={{
        left: 0,
        width: this.state.width,
        top: this.state.top, //StatusBar.currentHeight,
        height: this.state.height,
        position: 'absolute',
        backgroundColor:'transparent'}}
        {...this.props}/>
    );
  }
}
