package com.MicroserviceApp.DeviceMicroservice.Controller;

import com.MicroserviceApp.DeviceMicroservice.Models.WeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "temperature")
//@EnableBinding(Source.class)
public class TemperatureController {
//    @Autowired
//    private MessageChannel output;

    @PostMapping()
    public WeatherModel post(@RequestBody WeatherModel temperature){
//        this.output.send(MessageBuilder.withPayload(temperature).build());
        return  temperature;

    }
}
