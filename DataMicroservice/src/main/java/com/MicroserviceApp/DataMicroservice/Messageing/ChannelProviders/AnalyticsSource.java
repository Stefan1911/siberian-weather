package com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface AnalyticsSource {
  String OUTPUT = "AnalyticsOutput";

  @Output(AnalyticsSource.OUTPUT)
  MessageChannel output();

}
