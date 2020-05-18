package com.MicroserviceApp.DeviceMicroservice.Messageing;

import com.MicroserviceApp.DeviceMicroservice.Messageing.WeatehrSource.WindSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;

@EnableBinding(WindSource.class)
public class WindChannelProvider implements IChannelProvider {
    @Autowired
    private MessageChannel WindOutput;

    @Override
    public MessageChannel getChanel() {
        return this.WindOutput;
    }
}
