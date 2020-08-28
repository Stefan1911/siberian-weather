package com.MicroserviceApp.AnalyticsMicroservice.Messaging.Source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface AnalyticsSource {
  String INPUT = "AnalyticsInput";

  @Input(INPUT)
  MessageChannel input();
}
