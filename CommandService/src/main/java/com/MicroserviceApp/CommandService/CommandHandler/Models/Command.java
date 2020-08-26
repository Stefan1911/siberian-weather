package com.MicroserviceApp.CommandService.CommandHandler.Models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
public class Command {
  private String commandName;
  private List<String> commandParameters;

}
