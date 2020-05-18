package com.MicroserviceApp.DeviceMicroservice.Messageing;

import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ChannelProviderFactory {
    private HashMap<weatherRunner.WeatherStats,IChannelProvider> channelProviderMap;

    @Autowired
    public ChannelProviderFactory(TemperatureChannelProvider temperatureChannelProvider, WindChannelProvider windChannelProvider) {
        this.channelProviderMap = new HashMap<>();
        this.channelProviderMap.put(weatherRunner.WeatherStats.TEMPERATURE,temperatureChannelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherStats.WIND,windChannelProvider);
    }
    public IChannelProvider getProvider(weatherRunner.WeatherStats weatherStats){
        return this.channelProviderMap.get(weatherStats);
    }
}
