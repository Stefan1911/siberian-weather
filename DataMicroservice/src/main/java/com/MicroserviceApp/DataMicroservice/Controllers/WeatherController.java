package com.MicroserviceApp.DataMicroservice.Controllers;

import com.MicroserviceApp.DataMicroservice.Models.TemperatureModel;
import com.MicroserviceApp.DataMicroservice.Models.WeatherModel;
import com.MicroserviceApp.DataMicroservice.Persitance.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.convert.ThreeTenBackPortConverters;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    @Autowired
    WeatherRepository weatherRepository;

    @PostMapping("/{modelName}/add")
    public WeatherModel Add(@PathVariable String modelName,@RequestBody Object weatherModel) throws ClassNotFoundException {
        return  weatherRepository.add((WeatherModel)weatherModel);
    }

    @GetMapping("/{modelName}/get/{value}")
    public List Get(@PathVariable String modelName, @PathVariable int value){
        return weatherRepository.get(value, TemperatureModel.class);
    }
    @GetMapping("/{modelName}/getByDate/{dateFrom}/{dateTo}")
    public List GetInDateInterval(@PathVariable String modelName,@PathVariable String dateFrom,@PathVariable String dateTo) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
        WeatherEnum.valueOfType(modelName);
        return weatherRepository.getByDate(formatter.parse(dateFrom), formatter.parse(dateTo), WeatherEnum.valueOfClass(modelName));
    }
    @GetMapping("/{modelName}/findAll")
    public List<TemperatureModel> FindAll(@PathVariable String modelName){
       return weatherRepository.getAll(TemperatureModel.class);

    }


}
