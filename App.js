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
import {Platform, View} from "react-native";
import * as Font from "expo-font"

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
        return !fontsAreLoaded ? <View/> : <HybridApp lockOrientation={this.lockOrientation}/>
    }
}

