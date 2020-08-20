package com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Contracts;

import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Exceptions.InvalidCommandException;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.ActuatorInfo;
import com.MicroserviceApp.DeviceMicroservice.Models.ActuatorCommand;
import java.util.List;

public interface IActuator {

  public void execute(ActuatorCommand command) throws InvalidCommandException;
  public ActuatorInfo getActuatorInfo();

}
