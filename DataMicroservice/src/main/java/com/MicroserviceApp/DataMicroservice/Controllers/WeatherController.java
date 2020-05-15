package com.MicroserviceApp.DataMicroservice.Controllers;

import com.MicroserviceApp.DataMicroservice.Models.TemperatureModel;
import com.MicroserviceApp.DataMicroservice.Models.WeatherModel;
import com.MicroserviceApp.DataMicroservice.Persitance.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    @Autowired
    WeatherRepository<TemperatureModel> temperatureRepository;

    @PostMapping("/add")
    public TemperatureModel Add(@RequestBody TemperatureModel temperature){
        return temperatureRepository.add(temperature);
    }
    @GetMapping("/get")
    public WeatherModel Get(){
        return null;
    }
    @GetMapping("/findAll")
    public List<TemperatureModel> FindAll(){
       return temperatureRepository.getAll(TemperatureModel.class);

    }


}
