package com.MicroserviceApp.DataMicroservice.Models;

import java.lang.reflect.Type;

public enum WeatherAttributeType {
    TEMPERATURE("temperature",TemperatureModel.class),
    WIND("wind",WindModel.class),
    WATER_LEVEL("water_level",WaterLevelModel.class),
    HUMIDITY("humidity",HumidityModel.class),
    VISIBILITY("visibility",VisibilityModel.class),
    PRESSURE("pressure",PressureModel.class),
    PRECIPITATION("precipitation",PrecipitationModel.class);

    public final String label;
    public final Class modelClass;
    private WeatherAttributeType(String label, Class type) {
        this.modelClass = type;
        this.label = label;
    }

}
