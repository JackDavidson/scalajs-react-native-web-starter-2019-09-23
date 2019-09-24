import React from "react";
import {Dimensions, View, Platform, Text} from "react-native";

// since react-native-web doesn't like text being a direct child of a view
export default class TextWrapper extends React.Component {
  render() {
    return (
      <Text {...this.props}/>
    );
  }
}
