package com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface WindChannelProvider {
    String INPUT = "WindInput";

    @Input(INPUT)
    MessageChannel input();
}
