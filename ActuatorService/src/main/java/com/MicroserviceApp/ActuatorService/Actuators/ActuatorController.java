package com.MicroserviceApp.ActuatorService.Actuators;

import com.MicroserviceApp.ActuatorService.Models.CommandParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/actuators")
public class ActuatorController {

    @PostMapping
    public void sirenCommand(CommandParameters parameters){

    }
}
