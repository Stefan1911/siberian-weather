package com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface VisibilityChannelProvider {
    String INPUT = "VisibilityInput";

    @Input(INPUT)
    MessageChannel input();
}
