package com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Actuators;

import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Contracts.IActuator;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Exceptions.InvalidCommandException;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.ActuatorInfo;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.ActuatorType;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.Arguments.IntegerArgument;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.CommandDefinition;
import com.MicroserviceApp.DeviceMicroservice.Models.ActuatorCommand;
import java.util.Arrays;
import java.util.List;
import org.apache.kafka.common.protocol.types.Field.Str;

public class SirenActuator implements IActuator {

  private final ActuatorType actuatorType = ActuatorType.SIREN;
  private final List<CommandDefinition> supportedCommands = getSupportedCommands();



  @Override
  public void execute(ActuatorCommand command) throws InvalidCommandException {
    if(validateCommand(command))
      System.out.println("executing command :" + command);
    else
      throw new InvalidCommandException(command);
  }

  @Override
  public ActuatorInfo getActuatorInfo() {
    return new ActuatorInfo(actuatorType,supportedCommands) ;
  }

  private List<CommandDefinition> getSupportedCommands() {
    CommandDefinition definition1 = CommandDefinition.builder()
        .commandName("alarm")
        .arguments(Arrays.asList(new IntegerArgument(10,1)))
        .description("sounding the alarm for unusual values, the arguments is the durations of the alarm in seconds")
        .build();

    CommandDefinition definition2 = CommandDefinition.builder()
        .commandName("TestDevice")
        .description("testing the device")
        .build();

    return Arrays.asList(definition1, definition2);
  }

  private boolean validateCommand(ActuatorCommand command){
    //todo command validation
    return true;
  }
}
