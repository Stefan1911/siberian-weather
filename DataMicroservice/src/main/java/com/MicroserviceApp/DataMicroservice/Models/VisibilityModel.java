package com.MicroserviceApp.DataMicroservice.Models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Visibility")
public class VisibilityModel extends WeatherModel {
    @Override
    public Class getType() {
        return this.getClass();
    }
}
