import React from "react";
import {Text} from "react-native";

export default class StringLine extends React.Component {
  constructor(props) {
    super(props)
  }
  render() {

    return (
      <Text style={{...style, left: this.props.left, top: this.props.top,
        fontSize: this.props.fontSize}}>{this.props.text}</Text>
    );
  }
}

const style = {
  fontFamily: 'Courier New',
  position:'absolute',
}
