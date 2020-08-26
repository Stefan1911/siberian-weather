package com.MicroserviceApp.DataMicroservice.Persitance;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.Models.WeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component
public class WeatherRepository<T extends WeatherModel> implements IWeatherRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public WeatherRepository() {
    }

    @Override
    public WeatherModel add(WeatherModel weather) {
        return mongoTemplate.save(weather);
    }

    @Override
    public List get(int value , Class type) {
        BasicQuery query = new BasicQuery("{ 'value': "+value+" }");
        return mongoTemplate.find(query,type);
    }

    @Override
    public List getByDate(Date fromDate, Date toDate, Class type) {
        Criteria between = where("date").gt(fromDate).lt(toDate);
        return mongoTemplate.find(query(between),type);
    }

    @Override
    public List getAll(Class type) {
        return mongoTemplate.findAll(type);
    }

}
