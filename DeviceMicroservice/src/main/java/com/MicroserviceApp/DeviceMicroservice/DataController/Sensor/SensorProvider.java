package com.MicroserviceApp.DeviceMicroservice.DataController.Sensor;

import com.MicroserviceApp.DeviceMicroservice.DataController.Sensor.ISensor;
import com.MicroserviceApp.DeviceMicroservice.DataController.Sensor.RandomSensor;
import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SensorProvider {
    private HashMap<weatherRunner.WeatherStats,ISensor> hashMap;

    public SensorProvider() {
        RandomSensor randomSensor = new RandomSensor();
        this.hashMap = new HashMap<>();
        this.hashMap.put(weatherRunner.WeatherStats.TEMPERATURE,randomSensor);
        this.hashMap.put(weatherRunner.WeatherStats.WIND,randomSensor);
    }

    public ISensor getSensor(weatherRunner.WeatherStats stat){
        return this.hashMap.get(stat);
    }
}
