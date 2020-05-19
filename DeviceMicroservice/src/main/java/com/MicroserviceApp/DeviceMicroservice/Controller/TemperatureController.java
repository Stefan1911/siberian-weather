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
    public HashMap getConfig(){
        return dataControllerSettings.getMap();
    }

    @PostMapping()
    public ResponseEntity<HashMap<weatherRunner.WeatherStats, Integer>> post(@RequestBody HashMap<weatherRunner.WeatherStats,Integer> map){
        for(weatherRunner.WeatherStats stat : weatherRunner.WeatherStats.values()){
            if(!map.containsKey(stat)){
                return new ResponseEntity<HashMap<weatherRunner.WeatherStats,Integer>>(HttpStatus.BAD_REQUEST);
            }
            if(map.get(stat) == null){
                return new ResponseEntity<HashMap<weatherRunner.WeatherStats,Integer>>(HttpStatus.BAD_REQUEST);
            }
        }
        this.dataControllerSettings.setMap(map);
        this.runner.restartAllDataControllers();
        return new ResponseEntity<>(map,HttpStatus.OK);

    }
}
