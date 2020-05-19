package com.MicroserviceApp.DeviceMicroservice.Messageing;

import com.MicroserviceApp.DeviceMicroservice.Messageing.WeatehrSource.TemperatureSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(TemperatureSource.class)
public class TemperatureChannelProvider implements IChannelProvider {

    @Autowired
    private MessageChannel TemperatureOutput;

    @Override
    public MessageChannel getChanel() {
        return this.TemperatureOutput;
    }
}
