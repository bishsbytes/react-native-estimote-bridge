
# react-native-estimote-bridge

## Getting started

`$ npm install react-native-estimote-bridge --save`

### Mostly automatic installation

`$ react-native link react-native-estimote-bridge`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-estimote-bridge` and add `RNEstimoteBridge.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNEstimoteBridge.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNEstimoteBridgePackage;` to the imports at the top of the file
  - Add `new RNEstimoteBridgePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-estimote-bridge'
  	project(':react-native-estimote-bridge').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-estimote-bridge/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-estimote-bridge')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNEstimoteBridge.sln` in `node_modules/react-native-estimote-bridge/windows/RNEstimoteBridge.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Com.Reactlibrary.RNEstimoteBridge;` to the usings at the top of the file
  - Add `new RNEstimoteBridgePackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNEstimoteBridge from 'react-native-estimote-bridge';

// TODO: What to do with the module?
RNEstimoteBridge;
```
  