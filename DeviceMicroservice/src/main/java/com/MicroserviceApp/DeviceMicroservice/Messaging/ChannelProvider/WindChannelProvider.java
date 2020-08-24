package com.MicroserviceApp.DeviceMicroservice.Messaging.ChannelProvider;

import com.MicroserviceApp.DeviceMicroservice.Messaging.IChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Messaging.Source.WindSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(WindSource.class)
public class WindChannelProvider implements IChannelProvider {
    @Autowired
    private MessageChannel WindOutput;

    @Override
    public MessageChannel getChanel() {
        return this.WindOutput;
    }
}
