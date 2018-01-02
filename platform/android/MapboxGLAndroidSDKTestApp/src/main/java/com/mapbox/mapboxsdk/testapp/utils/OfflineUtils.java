package com.mapbox.mapboxsdk.testapp.utils;

import android.support.annotation.NonNull;

import com.google.gson.JsonObject;

import timber.log.Timber;

import static com.mapbox.mapboxsdk.testapp.activity.offline.OfflineActivity.JSON_CHARSET;
import static com.mapbox.mapboxsdk.testapp.activity.offline.OfflineActivity.JSON_FIELD_REGION_NAME;

public class OfflineUtils {

  public static String convertRegionName(@NonNull byte[] metadata) {
    try {
      JsonObject jsonObject = new JsonObject();
      String json = new String(metadata, JSON_CHARSET);
      jsonObject.addProperty(JSON_FIELD_REGION_NAME, json);
      return jsonObject.getAsString();
    } catch (Exception exception) {
      return null;
    }
  }

  public static byte[] convertRegionName(String regionName) {
    byte[] metadata = null;
    try {
      JsonObject jsonObject = new JsonObject();
      jsonObject.addProperty(JSON_FIELD_REGION_NAME, regionName);
      String json = jsonObject.getAsString();
      metadata = json.getBytes(JSON_CHARSET);
    } catch (Exception exception) {
      Timber.e(exception, "Failed to encode metadata: ");
    }
    return metadata;
  }

}
