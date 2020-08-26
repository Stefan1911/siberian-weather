package com.MicroserviceApp.DeviceMicroservice.DataCollector;



import com.MicroserviceApp.DeviceMicroservice.Models.Enumerations.WeatherAttributeType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataCollectorSettings {
    @Getter @Setter
    private Integer readRate;
    @Getter @Setter
    private Integer batchSize;
    @Getter
    private WeatherAttributeType valueType;

    public DataCollectorSettings(@Value("${collector.type}") WeatherAttributeType valueType) {
        readRate = 1000; // default readRate
        batchSize = 5; // default readRate
        this.valueType = valueType;
    }

}
