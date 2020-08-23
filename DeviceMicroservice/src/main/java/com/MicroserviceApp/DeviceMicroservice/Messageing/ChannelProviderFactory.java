package com.MicroserviceApp.DeviceMicroservice.Messageing;

import com.MicroserviceApp.DeviceMicroservice.Messageing.ChannelProvider.*;
import com.MicroserviceApp.DeviceMicroservice.Models.Enumerations.WeatherAttributeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ChannelProviderFactory {
    private HashMap<WeatherAttributeType, IChannelProvider> channelProviderMap;

    @Autowired
    public ChannelProviderFactory(TemperatureChannelProvider temperatureChannelProvider,
                                  WindChannelProvider windChannelProvider,
                                  WaterLevelProvider waterLevelProvider,
                                  HumidityChannelProvider humidityChannelProvider,
                                  PrecipitationChannelProvider precipitationChannelProvider,
                                  PressureChannelProvider pressureChannelProvider,
                                  VisibilityChannelProvider visibilityChannelProvider) {
        this.channelProviderMap = new HashMap<>();
        this.channelProviderMap.put(WeatherAttributeType.TEMPERATURE,temperatureChannelProvider);
        this.channelProviderMap.put(WeatherAttributeType.WIND,windChannelProvider);
        this.channelProviderMap.put(WeatherAttributeType.WATER_LEVEL, waterLevelProvider);
        this.channelProviderMap.put(WeatherAttributeType.HUMIDITY, humidityChannelProvider);
        this.channelProviderMap.put(WeatherAttributeType.PRECIPITATION, precipitationChannelProvider);
        this.channelProviderMap.put(WeatherAttributeType.PRESSURE, pressureChannelProvider);
        this.channelProviderMap.put(WeatherAttributeType.VISIBILITY, visibilityChannelProvider);
    }
    public IChannelProvider getProvider(WeatherAttributeType weatherAttributeType){
        return this.channelProviderMap.get(weatherAttributeType);
    }
}
