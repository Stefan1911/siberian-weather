package com.MicroserviceApp.CommandService.CommandHandler.Models;

import com.MicroserviceApp.CommandService.CommandHandler.Models.CommandDefinition.CommandDefinition;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActuatorInfo {
  private ActuatorType actuatorType;
  List<CommandDefinition> commandDefinitionList;
}
