package com.MicroserviceApp.DataMicroservice.Models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Precipitation")
public class PrecipitationModel extends WeatherModel {
}
