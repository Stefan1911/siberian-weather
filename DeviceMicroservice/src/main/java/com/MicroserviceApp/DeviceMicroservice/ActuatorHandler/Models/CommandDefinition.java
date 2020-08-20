package com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models;

import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.Arguments.CommandArgument;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommandDefinition {
  private String commandName;
  private List<CommandArgument> arguments;
  private String description;
}

