package com.MicroserviceApp.DataMicroservice.Models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Humidity")
public class HumidityModel extends WeatherModel {
}
