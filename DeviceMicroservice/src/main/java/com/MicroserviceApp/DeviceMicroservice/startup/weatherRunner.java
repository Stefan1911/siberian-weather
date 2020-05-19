package com.MicroserviceApp.DeviceMicroservice.startup;

import com.MicroserviceApp.DeviceMicroservice.DataController.DataController;
import com.MicroserviceApp.DeviceMicroservice.DataController.DataControllerSettings;
import com.MicroserviceApp.DeviceMicroservice.DataController.Sensor.SensorProvider;
import com.MicroserviceApp.DeviceMicroservice.Messageing.ChannelProviderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class weatherRunner implements ApplicationRunner {

    @Autowired
    private ChannelProviderFactory channelProviderFactory;
    @Autowired
    private SensorProvider sensorProvider;
    @Autowired
    private DataControllerSettings dataControllerSettings;

    private HashMap<WeatherStats,DataController> dataControllerMap = new HashMap<>();
    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (WeatherStats stat : WeatherStats.values()){
            DataController controller = new DataController(stat,this.channelProviderFactory,this.sensorProvider,this.dataControllerSettings);
            this.dataControllerMap.put(stat,controller);
            controller.startReading();
        }
    }

    public DataController getDataController(WeatherStats stat){
        return this.dataControllerMap.get(stat);
    }
    public void restartAllDataControllers(){
        for (DataController data : this.dataControllerMap.values()){
            data.restartReading();
        }
    }

    public enum WeatherStats{
        TEMPERATURE("temperature"),
        WIND("wind"),
        WATERLEVEL("water_level"),
        HUMIDITY("humidity"),
        VISIBILITY("visibility"),
        PRESSURE("pressure"),
        PRECIPITATION("precipitation");

        public final String label;
        private WeatherStats(String label) {
            this.label = label;
        }
    }
}
