package com.MicroserviceApp.DeviceMicroservice.Messageing.ChannelProvider;

import com.MicroserviceApp.DeviceMicroservice.Messageing.IChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Messageing.WeatehrSource.PrecipitationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(PrecipitationSource.class)
public class PrecipitationChannelProvider implements IChannelProvider {
    @Autowired
    private  MessageChannel PrecipitationOutput;
    @Override
    public MessageChannel getChanel() {
        return this.PrecipitationOutput;
    }
}
