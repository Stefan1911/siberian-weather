package com.MicroserviceApp.DeviceMicroservice.Gateway.Controllers;

import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Contracts.IActuatorHandler;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Exceptions.InvalidCommandException;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.ActuatorInfo;
import com.MicroserviceApp.DeviceMicroservice.Models.ActuatorCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "actuator")
public class ActuatorController {

  @Autowired
  private IActuatorHandler actuatorHandler;

  @GetMapping
  private ResponseEntity<ActuatorInfo> getInfo(){
    return new ResponseEntity<>(actuatorHandler.getActuatorSettings(), HttpStatus.OK);
  }

  @PostMapping
  private ResponseEntity execute(@RequestBody ActuatorCommand command) throws InvalidCommandException {
    actuatorHandler.executeCommand(command);
    return  new ResponseEntity(HttpStatus.ACCEPTED);
  }


}
