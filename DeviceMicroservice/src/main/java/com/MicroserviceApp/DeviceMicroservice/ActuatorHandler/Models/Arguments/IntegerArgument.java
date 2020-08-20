package com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.Arguments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@AllArgsConstructor
public class IntegerArgument extends CommandArgument {
  private final String argumentType = "Integer";

  private Integer maxValue;
  private Integer minValue;
}
