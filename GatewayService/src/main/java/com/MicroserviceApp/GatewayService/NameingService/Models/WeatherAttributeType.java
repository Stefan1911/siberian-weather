package com.MicroserviceApp.GatewayService.NameingService.Models;

public enum WeatherAttributeType {
  TEMPERATURE("temperature"),
  WIND("wind"),
  WATER_LEVEL("water_level"),
  HUMIDITY("humidity"),
  VISIBILITY("visibility"),
  PRESSURE("pressure"),
  PRECIPITATION("precipitation");

  public final String label;
  private WeatherAttributeType(String label) {
    this.label = label;
  }

  public static boolean contains(String value){
    for (WeatherAttributeType c : WeatherAttributeType.values()) {
      if (c.label.equals(value.toLowerCase())) {
        return true;
      }
    }
    return false;
  }
}
