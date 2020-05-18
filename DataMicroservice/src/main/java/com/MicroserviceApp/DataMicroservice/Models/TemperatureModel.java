package com.MicroserviceApp.DataMicroservice.Models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Temperature")
public class TemperatureModel extends WeatherModel {
}
