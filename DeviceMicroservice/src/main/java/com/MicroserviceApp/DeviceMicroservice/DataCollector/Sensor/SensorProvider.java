package com.MicroserviceApp.DeviceMicroservice.DataCollector.Sensor;

import com.MicroserviceApp.DeviceMicroservice.Models.Enumerations.WeatherAttributeType;
import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
public class SensorProvider {
    private HashMap<WeatherAttributeType,ISensor> hashMap;

    public SensorProvider() throws IOException {
        RandomSensor randomSensor = new RandomSensor();
        this.hashMap = new HashMap<>();
        for (WeatherAttributeType stat : WeatherAttributeType.values()){
            this.hashMap.put(stat,new FileSensor(stat));
        }
    }

    public ISensor getSensor(WeatherAttributeType stat){
        return this.hashMap.get(stat);
    }
}
