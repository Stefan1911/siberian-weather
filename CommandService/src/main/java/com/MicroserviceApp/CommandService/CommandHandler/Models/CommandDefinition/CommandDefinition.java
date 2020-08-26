package com.MicroserviceApp.CommandService.CommandHandler.Models.CommandDefinition;

import com.MicroserviceApp.CommandService.CommandHandler.Models.CommandDefinition.Arguments.CommandArgument;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommandDefinition {
  private String commandName;
  private List<CommandArgument> arguments;
  private String description;
}

