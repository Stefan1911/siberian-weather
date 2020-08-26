package com.MicroserviceApp.DataMicroservice.Controllers;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.Models.*;
import com.MicroserviceApp.DataMicroservice.Persitance.WeatherRepository;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public enum WeatherEnum {

    HUMIDITY("humidity", HumidityModel.class),
    PRECIPITATION("precipitation", PrecipitationModel.class),
    PRESSURE("pressure", PressureModel.class),
    TEMPERATURE("temperature", TemperatureModel.class),
    VISIBILITY("visibility", VisibilityModel.class),
    WATERLEVEL("waterLevel", WeatherModel.class),
    WIND("wind", WindModel.class);

     private static final Map<String, WeatherEnum> BY_NAME = new HashMap<>();
     private static final Map<WeatherEnum,Type> BY_MODEL = new HashMap<>();
     private static final Map<String,Type> BY_TYPE = new HashMap<>();
     private static final Map<String,Class> BY_CLASS = new HashMap<>();

     static {
            for (WeatherEnum e : values()) {
                BY_NAME.put(e.name, e);
                BY_MODEL.put(e,e.model);
                BY_TYPE.put(e.name,e.model);
                BY_CLASS.put(e.name, e.model.getClass());
            }
        }

        public final Type model;
        public final String name;

        private WeatherEnum(String name, Type model) {
            this.name = name;
            this.model = model;
        }

        public static WeatherEnum valueOfName(String name) {
            return BY_NAME.get(name);
        }
        public static Type valueOfModel(WeatherEnum weather) {
            return BY_MODEL.get(weather);
        }
        public static Type valueOfType(String name) {
          return BY_TYPE.get(name.toLowerCase());
         }
        public static Class valueOfClass(String name) {
            return BY_CLASS.get(name.toLowerCase());
        }
//        public static IWeatherRepository getRepository(String name) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//            Class<?> clazz = Class.forName("com.MicroserviceApp.DataMicroservice.Models."+ name);
//            Constructor<?> cons = clazz.getDeclaredConstructor();
//            cons.setAccessible(true);
//
//            return null;
//        }
}
