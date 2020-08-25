package com.MicroserviceApp.CommandService.CommandHandler.Models.CommandDefinition.Arguments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class IntegerArgument extends CommandArgument {
  private final String argumentType = "Integer";

  private Integer maxValue;
  private Integer minValue;
}
