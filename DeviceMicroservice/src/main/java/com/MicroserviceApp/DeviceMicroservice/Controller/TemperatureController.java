package com.MicroserviceApp.DeviceMicroservice.Controller;

import com.MicroserviceApp.DeviceMicroservice.DataController.DataControllerSettings;
import com.MicroserviceApp.DeviceMicroservice.Models.WeatherModel;
import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
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
    public HashMap getConfig(){
        return dataControllerSettings.getMap();
    }

    @PostMapping()
    public HashMap<weatherRunner.WeatherStats,Integer> post(@RequestBody HashMap<weatherRunner.WeatherStats,Integer> map){
        this.dataControllerSettings.setMap(map);
        this.runner.restartAllDataControllers();
        return this.dataControllerSettings.getMap();

    }
}
