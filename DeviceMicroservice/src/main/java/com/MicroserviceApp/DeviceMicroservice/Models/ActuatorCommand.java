package com.MicroserviceApp.DeviceMicroservice.Models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
public class ActuatorCommand {
  private String commandName;
  private List<String> commandParameters;
}
