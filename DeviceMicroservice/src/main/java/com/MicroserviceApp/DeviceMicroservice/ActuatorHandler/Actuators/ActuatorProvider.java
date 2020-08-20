package com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Actuators;

import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Exceptions.UnsupportedActuatorType;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.ActuatorType;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Contracts.IActuator;
import org.springframework.stereotype.Component;

@Component
public class ActuatorProvider {
  public IActuator getActuator(ActuatorType actuatorType) throws UnsupportedActuatorType {
    switch (actuatorType){
      case SIREN:return new SirenActuator();
      default: throw new UnsupportedActuatorType(actuatorType);
    }

  }
}
