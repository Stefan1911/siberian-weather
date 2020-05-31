package com.MicroserviceApp.DataMicroservice.Persitance;

import com.MicroserviceApp.DataMicroservice.Context.IBatchRepository;
import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.Models.HumidityModel;
import com.MicroserviceApp.DataMicroservice.Models.WeatherAttributeType;
import com.MicroserviceApp.DataMicroservice.Models.WeatherModel;
import com.MicroserviceApp.DataMicroservice.Persitance.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.script.ScriptEngine;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class BatchRepository implements IBatchRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public BatchRepository() {
    }

    public HashMap<WeatherAttributeType, List<WeatherModel>> getBatch(Date dateFrom, Date dateTo){
        HashMap<WeatherAttributeType, List<WeatherModel>> batch = new HashMap<>();
        Criteria criteria = Criteria.where("date").gt(dateFrom).lt(dateTo);
        for (WeatherAttributeType attributeType : WeatherAttributeType.values()){
            List<WeatherModel> weatherModelList = mongoTemplate.find(new Query(criteria),attributeType.modelClass);
            batch.put(attributeType, weatherModelList);
        }
        return  batch;
    }

}
