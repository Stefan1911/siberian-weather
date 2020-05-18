package com.MicroserviceApp.DeviceMicroservice.startup;

import com.MicroserviceApp.DeviceMicroservice.DataController.DataController;
import com.MicroserviceApp.DeviceMicroservice.DataController.SensorProvider;
import com.MicroserviceApp.DeviceMicroservice.Messageing.ChannelProviderFactory;
import com.MicroserviceApp.DeviceMicroservice.Messageing.TemperatureChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Messageing.WindChannelProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class weatherRunner implements ApplicationRunner {

    @Autowired
    private ChannelProviderFactory channelProviderFactory;
    @Autowired
    private SensorProvider sensorProvider;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (WeatherStats stat : WeatherStats.values()){
            DataController controller = new DataController(this.channelProviderFactory.getProvider(stat),this.sensorProvider.getSensor(stat),1000);
            controller.startReading();
        }
    }

    public enum WeatherStats{
        TEMPERATURE,
        WIND
    }
}
