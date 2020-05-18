package com.MicroserviceApp.DataMicroservice.Models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Pressure")
public class PressureModel extends WeatherModel {
}
