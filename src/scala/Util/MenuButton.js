import {Image, TouchableHighlight, TouchableOpacity} from "react-native";
import React from "react";

export default function MenuButton(props) {
  return (
    <TouchableOpacity onPress={props.onPress} style={props.style}>
      <Image source={props.source}  style={{width: props.style.width, height: props.style.height}}/>
    </TouchableOpacity>
  )
}