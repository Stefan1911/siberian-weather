package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.AnalyticsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(AnalyticsSource.class)
public class AnalyticsChanelProvider {

  @Autowired
  private MessageChannel AnalyticsOutput;

  public MessageChannel getChanel() {
    return AnalyticsOutput;
  }
}
