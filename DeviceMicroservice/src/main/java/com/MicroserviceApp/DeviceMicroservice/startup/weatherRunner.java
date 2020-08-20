package com.MicroserviceApp.DeviceMicroservice.startup;

import com.MicroserviceApp.DeviceMicroservice.DataCollector.DataCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class weatherRunner implements ApplicationRunner {

    @Autowired
    private DataCollector dataController;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.dataController.startReading();
    }

    public DataCollector getDataController(WeatherAttributeType stat){
        return this.dataController;
    }
    public void restartDataController(){
        this.dataController.restartReading();
    }
    public void startDataController(){
        this.dataController.startReading();
    }
    public void stopDataController(){
        this.dataController.stopReading();
    }

    public enum WeatherAttributeType {
        TEMPERATURE("temperature"),
        WIND("wind"),
        WATER_LEVEL("water_level"),
        HUMIDITY("humidity"),
        VISIBILITY("visibility"),
        PRESSURE("pressure"),
        PRECIPITATION("precipitation");

        public final String label;
        private WeatherAttributeType(String label) {
            this.label = label;
        }

        public static boolean contains(String value){
            for (WeatherAttributeType c : WeatherAttributeType.values()) {
                if (c.label.equals(value.toLowerCase())) {
                    return true;
                }
            }
            return false;
        }
    }
}
