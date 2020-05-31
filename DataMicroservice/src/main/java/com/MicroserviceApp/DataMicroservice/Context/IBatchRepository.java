package com.MicroserviceApp.DataMicroservice.Context;

import com.MicroserviceApp.DataMicroservice.Models.WeatherAttributeType;
import com.MicroserviceApp.DataMicroservice.Models.WeatherModel;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface IBatchRepository {
    HashMap<WeatherAttributeType, List<WeatherModel>> getBatch(Date dateFrom, Date dateTo);
}
