import { Platform, Dimensions } from 'react-native'
const {height, width} = Dimensions.get('window');

export const model = {
  tab: {
    strings: 6,
    length: 55
  },
  display: {
    platform: Platform.OS,
    width: width,
    height: height,
    scale: .2,
    desktop: (Platform.OS === 'web'),
    portrait: height > width
  }
}
export default model