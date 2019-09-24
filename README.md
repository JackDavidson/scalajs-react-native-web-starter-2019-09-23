# Scalajs React Native Web Starter

The purpose of this repository is to provide a minimal example app that combines scalajs-react-native with react-native-web for a cross-platform web/android/ios app written in mixed scala/react.

## Quick Start

1. install prerequisites(node, sbt, and java openjdk 8) - tested on ubuntu 19.04
```bash
sudo apt-get update
sudo apt-get install openjdk-8-jdk-headless

mkdir -p ~/.local/lib/
cd ~/.local/lib/
wget https://nodejs.org/dist/v10.16.3/node-v10.16.3-linux-x64.tar.xz
tar -xf node-v10.16.3-linux-x64.tar.xz
mv node-v10.16.3-linux-x64 node
rm node-v10.16.3-linux-x64.tar.xz
mkdir -p ~/.local/bin
ln -s ~/.local/lib/node/bin/node ~/.local/bin/node
ln -s ~/.local/lib/node/bin/npm ~/.local/bin/npm
export PATH=$PATH:~/.local/bin/
** add that line to the end of your bashrc to permanently add it to your path **

echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
sudo apt-get update
sudo apt-get install sbt

** cd into this repository **
npm install
```

2. have scala.js generate the javascript file, and watch for updates
```bash
cd scalajs-react-native-web-starter-2019-09-23/src/scala/
sbt ~fastOptJS
```

3. run
```bash
cd scalajs-react-native-web-starter-2019-09-23/
npm start
** first time through, node will ask to install expo. accept to let it install expo 
** a UI should open in your browser
** you can also simply press:
**  'a' to run on android emulator/phone
**  'w' to run for web
**  'i' to run on IOS
```

#### Tasks

*  add support for fullOptJS in build.sbt
*  Add some images and navigation
*  Remove references to tabmaker, the app I was working on when putting this together
*  Fully document setup
*  Create Dockerfile and provide instructions to use it for a truly quick start
*  Update version of react to latest

