
package com.reactlibrary;

import android.content.Context;

import com.estimote.coresdk.common.config.EstimoteSDK;
import com.estimote.coresdk.observation.region.beacon.BeaconRegion;
import com.estimote.coresdk.service.BeaconManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;

import java.util.UUID;

public class RNEstimoteBridgeModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private Context mApplicationContext;
  private BeaconManager beaconManager;
  private BeaconRegion region;

  public RNEstimoteBridgeModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    this.mApplicationContext = reactContext.getApplicationContext();
    this.beaconManager = new BeaconManager(this.mApplicationContext);
  }

  @Override
  public String getName() {
    return "RNEstimoteBridge";
  }

  @ReactMethod
  public void initialize(String appId, String appToken) {
    EstimoteSDK.initialize(this.mApplicationContext, appId, appToken);
  }

  @ReactMethod
  public void enableDebugLogging() {
    EstimoteSDK.enableDebugLogging(true);
  }

  @ReactMethod
  public void startRanging(ReadableMap region) {
    String regionName = region.hasKey("identifier") ? region.getString("identifier") : null;
    String regionUUID = region.hasKey("uuid") ? region.getString("uuid") : null;
    final BeaconManager beaconManager = this.beaconManager;
    final BeaconRegion beaconRegion = new BeaconRegion(regionName,
            UUID.fromString(regionUUID), null, null);

    beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
      @Override
      public void onServiceReady() {
        beaconManager.startRanging(beaconRegion);
      }
    });
  }


}