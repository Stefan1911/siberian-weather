package com.MicroserviceApp.DataMicroservice.Models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "WaterLevel")
public class WaterLevelModel extends WeatherModel{
    @Override
    public Class getType() {
        return this.getClass();
    }
}
