package com.MicroserviceApp.DeviceMicroservice.Gateway.Controllers;

import com.MicroserviceApp.DeviceMicroservice.DataCollector.DataCollectorSettings;
import com.MicroserviceApp.DeviceMicroservice.Gateway.DTOs.DataCollectorSettingsDTO;
import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "SensorMetaData")
public class TemperatureController {

    @Autowired
    DataCollectorSettings dataCollectorSettings;
    @Autowired
    weatherRunner runner;
    @GetMapping
    public DataCollectorSettings getConfig(){
        return dataCollectorSettings;
    }

    @PostMapping()
    public ResponseEntity<DataCollectorSettings> post(@RequestBody DataCollectorSettingsDTO settings){
        if(settings.getReadRate() == null || settings.getReadRate() <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(settings.getBatchSize() == null || settings.getBatchSize() <= 0 ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.dataCollectorSettings.setReadRate(settings.getReadRate());
        this.dataCollectorSettings.setBatchSize(settings.getBatchSize());
        this.runner.restartDataController();
        return new ResponseEntity<>(this.dataCollectorSettings,HttpStatus.OK);

    }

//    || weatherRunner.WeatherAttributeType.contains(settings.getValueType())
}
