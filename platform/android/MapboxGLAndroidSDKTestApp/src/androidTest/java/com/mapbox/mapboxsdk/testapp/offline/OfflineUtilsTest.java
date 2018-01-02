package com.mapbox.mapboxsdk.testapp.offline;

import com.mapbox.mapboxsdk.testapp.activity.BaseActivityTest;
import com.mapbox.mapboxsdk.testapp.activity.espresso.EspressoTestActivity;
import com.mapbox.mapboxsdk.testapp.utils.OfflineUtils;
import org.junit.Test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static junit.framework.Assert.assertEquals;

public class OfflineUtilsTest extends BaseActivityTest {

  private static final String REGION_NAME = "hello world";

  @Override
  protected Class getActivityClass() {
    return EspressoTestActivity.class;
  }

  @Test
  public void testOfflineUtilsConvertToBytes() {
    byte[] expected = REGION_NAME.getBytes(UTF_8);
    byte[] actual = OfflineUtils.convertRegionName(REGION_NAME);
    assertEquals("Bytes should match", expected, actual);
  }

  @Test
  public void testOfflineUtilsConvertToString() {
    String actual = OfflineUtils.convertRegionName(REGION_NAME.getBytes());
    assertEquals("Strings should match", REGION_NAME, actual);
  }

  @Test
  public void testOfflineUtilsConvertNoOp() {
    String convertNoOp = OfflineUtils.convertRegionName(OfflineUtils.convertRegionName(REGION_NAME));
    assertEquals("Strings should match", REGION_NAME, convertNoOp);
  }
}
