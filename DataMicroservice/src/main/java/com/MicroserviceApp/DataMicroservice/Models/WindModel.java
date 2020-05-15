package com.MicroserviceApp.DataMicroservice.Models;

import org.springframework.data.mongodb.core.mapping.Document;
/*@QueryEntity*/
@Document(collection = "Wind")
public class WindModel extends WeatherModel{

    @Override
    public Class getType() {
        return this.getClass();
    }
}
