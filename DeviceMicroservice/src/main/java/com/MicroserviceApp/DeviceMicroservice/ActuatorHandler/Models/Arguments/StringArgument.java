package com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.Arguments;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@AllArgsConstructor
public class StringArgument extends CommandArgument {
  private final String argumentType = "String";

  private List<String> allowedValues;
}
