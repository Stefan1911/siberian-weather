package com.MicroserviceApp.DeviceMicroservice.Controller;

import com.MicroserviceApp.DeviceMicroservice.DataController.DataControllerSettings;
import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "SensorMetaData")
public class TemperatureController {

    @Autowired
    DataControllerSettings dataControllerSettings;
    @Autowired
    weatherRunner runner;
    @GetMapping
    public DataControllerSettings getConfig(){
        return dataControllerSettings;
    }

    @PostMapping()
    public ResponseEntity<DataControllerSettings> post(@RequestBody DataControllerSettings settings){
        if(settings.getReadRate() == null || settings.getReadRate() <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(settings.getValueType() == null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.dataControllerSettings.setReadRate(settings.getReadRate());
        this.dataControllerSettings.setValueType(settings.getValueType());
        this.runner.restartDataController();
        return new ResponseEntity<>(this.dataControllerSettings,HttpStatus.OK);

    }

//    || weatherRunner.WeatherAttributeType.contains(settings.getValueType())
}
