package com.MicroserviceApp.AnalyticsMicroservice.Messaging.Models;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter @Setter
public class Command {
  private String commandName;
  private List<String> commandParameters;

}
