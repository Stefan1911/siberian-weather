package com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ActuatorInfo {
  private ActuatorType actuatorType;
  List<CommandDefinition> commandDefinitionList;
}
