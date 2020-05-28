package com.MicroserviceApp.DeviceMicroservice.DataController;


import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.springframework.stereotype.Component;

@Component
public class DataControllerSettings {
    private Integer readRate;
    private weatherRunner.WeatherAttributeType valueType;

    public Integer getReadRate() {
        return readRate;
    }

    public void setReadRate(Integer readRate) {
        this.readRate = readRate;
    }

    public weatherRunner.WeatherAttributeType getValueType() {
        return valueType;
    }

    public void setValueType(weatherRunner.WeatherAttributeType valueType) {
        this.valueType = valueType;
    }

    public DataControllerSettings() {
        this.readRate = 1000; // default readRate
        this.valueType = weatherRunner.WeatherAttributeType.TEMPERATURE; // default valueType
    }

}
