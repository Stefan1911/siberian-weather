package com.MicroserviceApp.DeviceMicroservice.Messageing;

import com.MicroserviceApp.DeviceMicroservice.Messageing.ChannelProvider.*;
import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ChannelProviderFactory {
    private HashMap<weatherRunner.WeatherAttributeType, IChannelProvider> channelProviderMap;

    @Autowired
    public ChannelProviderFactory(TemperatureChannelProvider temperatureChannelProvider,
                                  WindChannelProvider windChannelProvider,
                                  WaterLevelProvider waterLevelProvider,
                                  HumidityChannelProvider humidityChannelProvider,
                                  PrecipitationChannelProvider precipitationChannelProvider,
                                  PressureChannelProvider pressureChannelProvider,
                                  VisibilityChannelProvider visibilityChannelProvider) {
        this.channelProviderMap = new HashMap<>();
        this.channelProviderMap.put(weatherRunner.WeatherAttributeType.TEMPERATURE,temperatureChannelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherAttributeType.WIND,windChannelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherAttributeType.WATER_LEVEL, waterLevelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherAttributeType.HUMIDITY, humidityChannelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherAttributeType.PRECIPITATION, precipitationChannelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherAttributeType.PRESSURE, pressureChannelProvider);
        this.channelProviderMap.put(weatherRunner.WeatherAttributeType.VISIBILITY, visibilityChannelProvider);
    }
    public IChannelProvider getProvider(weatherRunner.WeatherAttributeType weatherAttributeType){
        return this.channelProviderMap.get(weatherAttributeType);
    }
}
