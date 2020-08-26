package com.MicroserviceApp.DeviceMicroservice.Messaging.Listeners;

import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Contracts.IActuatorHandler;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Exceptions.InvalidCommandException;
import com.MicroserviceApp.DeviceMicroservice.Messaging.Sink.CommandSink;
import com.MicroserviceApp.DeviceMicroservice.Models.ActuatorCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CommandSink.class)
public class CommandListener {

  @Autowired
  private IActuatorHandler actuatorHandler;

  @StreamListener(CommandSink.INPUT)
  public void execute(ActuatorCommand command) throws InvalidCommandException {
    actuatorHandler.executeCommand(command);
  }

}
