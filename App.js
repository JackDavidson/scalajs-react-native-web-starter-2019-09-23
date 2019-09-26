/*

import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>Open up App.js to start working on your app!</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});

*/

import React from "react";
import HybridApp from "./src/js/App";
import {Platform, View, StyleSheet} from "react-native";
import * as Font from "expo-font"

/*import Svg, {
  Circle,
  Ellipse,
  G,
  Text,
  TSpan,
  TextPath,
  Path,
  Polygon,
  Polyline,
  Line,
  Rect,
  Use,
  Image,
  Symbol,
  Defs,
  LinearGradient,
  RadialGradient,
  Stop,
  ClipPath,
  Pattern,
  Mask,
} from 'react-native-svg';
*/

export default class NativeApp extends React.Component {
    constructor() {
        super()
        this.state = {
            fontsAreLoaded: false
        }

    }

    async componentDidMount() {
        if (Platform.OS === 'android') {
            await Font.loadAsync({
                'Courier New': require('./assets/fonts/courier_new.ttf')
            })
        }
        this.setState({ fontsAreLoaded: true })
    }

    lockOrientation(orientation) {
        const expo = require('expo')
        switch (orientation) {
          case "all":
            expo.ScreenOrientation.allow(expo.ScreenOrientation.Orientation.ALL)
          case "portrait":
            expo.ScreenOrientation.allow(expo.ScreenOrientation.Orientation.PORTRAIT)
          case "landscape_left":
            expo.ScreenOrientation.allow(expo.ScreenOrientation.Orientation.LANDSCAPE_LEFT)
          case "landscape":
            expo.ScreenOrientation.allow(expo.ScreenOrientation.Orientation.LANDSCAPE)
        }
    }

    render() {
        const { fontsAreLoaded } = this.state
	    /*
	    return (
      <View
        style={[
          StyleSheet.absoluteFill,
          { alignItems: 'center', justifyContent: 'center' },
        ]}
      >
        <Svg height="50%" width="50%" viewBox="0 0 100 100">
          <Circle
            cx="50"
            cy="50"
            r="45"
            stroke="blue"
            strokeWidth="2.5"
            fill="green"
          />
          <Rect
            x="15"
            y="15"
            width="70"
            height="70"
            stroke="red"
            strokeWidth="2"
            fill="yellow"
          />
        </Svg>
      </View>
    );
    */
        return !fontsAreLoaded ? <View/> : <HybridApp lockOrientation={this.lockOrientation}/>
    }
}

