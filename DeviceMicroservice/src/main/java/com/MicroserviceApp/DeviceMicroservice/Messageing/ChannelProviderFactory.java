package com.MicroserviceApp.DeviceMicroservice.Messageing;

import com.MicroserviceApp.DeviceMicroservice.Messageing.ChannelProvider.*;
import com.MicroserviceApp.DeviceMicroservice.Messageing.IChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Messageing.WeatehrSource.WaterLevelSource;
import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ChannelProviderFactory {
    private HashMap<weatherRunner.WeatherStats, IChannelProvider> channelProviderMap;

    @Autowired
    public ChannelProviderFactory(TemperatureChannelProvider temperatureChannelProvider,
                                  WindChannelProvider windChannelProvider,
                                  WaterLevelProvider waterLevelProvider,
                                  HumidityChannelProvider humidityChannelProvider,
                                  PrecipitationChannelProvider precipitationChannelProvider,
                                  PressureChannelProvider pressureChannelProvider,
                                  VisibilityChannelProvider visibilityChannelProvider) {
        this.channelProviderMap = new HashMap<>();
        this.channelProviderMap.put(weatherRunner.WeatherStats.TEMPERATURE,temperatureChannelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherStats.WIND,windChannelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherStats.WATERLEVEL, waterLevelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherStats.HUMIDITY, humidityChannelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherStats.PRECIPITATION, precipitationChannelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherStats.PRESSURE, pressureChannelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherStats.VISIBILITY, visibilityChannelProvider);
    }
    public IChannelProvider getProvider(weatherRunner.WeatherStats weatherStats){
        return this.channelProviderMap.get(weatherStats);
    }
}
