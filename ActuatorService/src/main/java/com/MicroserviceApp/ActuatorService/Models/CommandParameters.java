package com.MicroserviceApp.ActuatorService.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CommandParameters {
    private String commandName;
    private List<String> commandParameters;
}
