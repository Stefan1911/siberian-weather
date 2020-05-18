package com.MicroserviceApp.DeviceMicroservice.DataController;


import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Getter @Setter
public class DataControllerSettings {
    private HashMap<weatherRunner.WeatherStats,Integer> map;

    public HashMap<weatherRunner.WeatherStats, Integer> getMap() {
        return map;
    }

    public void setMap(HashMap<weatherRunner.WeatherStats, Integer> map) {
        this.map = map;
    }

    public DataControllerSettings() {
        this.map = new HashMap<weatherRunner.WeatherStats, Integer>();
        for(weatherRunner.WeatherStats stat : weatherRunner.WeatherStats.values()){
            this.map.put(stat,1000);
        }
    }

    public int getStat(weatherRunner.WeatherStats stat){
        return this.map.get(stat);
    }
    public void setStat(weatherRunner.WeatherStats stat,Integer value){
        this.map.put(stat,value);
    };
}
