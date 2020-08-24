package com.MicroserviceApp.DeviceMicroservice.Messaging.ChannelProvider;

import com.MicroserviceApp.DeviceMicroservice.Messaging.IChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Messaging.Source.VisibilitySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(VisibilitySource.class)
public class VisibilityChannelProvider implements IChannelProvider {
    @Autowired
    private MessageChannel VisibilityOutput;

    @Override
    public MessageChannel getChanel() {
        return this.VisibilityOutput;
    }
}
