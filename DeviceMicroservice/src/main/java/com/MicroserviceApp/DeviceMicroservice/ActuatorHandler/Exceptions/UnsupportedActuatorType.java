package com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Exceptions;

import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.ActuatorType;

public class UnsupportedActuatorType extends Exception {

  public UnsupportedActuatorType(ActuatorType actuatorType) {
    super("the actuatorType : " + actuatorType +" is not yet supported");
  }
}
