package com.MicroserviceApp.CommandService.CommandHandler.Models.CommandDefinition.Arguments;

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
public class StringArgument extends CommandArgument {
  private final String argumentType = "String";

  private List<String> allowedValues;
}
