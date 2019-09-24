import React from "react";
import {Dimensions, View, Platform} from "react-native";
import StringLine from "./StringLine";

const courierSizing = {
  '28': {height: 30 , width: 17},
  '29': {height: 30 , width: 17.5},
  '30': {height: 30 , width: 18},
  '31': {height: 30 , width: 18.8},
  '32': {height: 30 , width: 19.4},
}

const defaultTab = {
  lines: [
    "-".repeat(100),
    "-".repeat(100),
    "-".repeat(100),
    "-".repeat(100),
    "-".repeat(100),
    "-".repeat(100),
  ],
  lineSemitones: [

  ]
}

export default class Tab extends React.Component {
  constructor(props) {
    super(props)

    // first thing: we need to figure out how many lines to create.
    const charsPerLine =

    this.state = {top: 0, fontSize: 32, tab: defaultTab}
  }
  render() {
    const charsPerLine = this.props.screenWidth/courierSizing[this.state.fontSize].width

    return (
      <StringLine
      text={'-'.repeat(parseInt(5))}
      fontSize={this.state.fontSize}
      left={5}
      top={20}
      />
    );
  }
}
