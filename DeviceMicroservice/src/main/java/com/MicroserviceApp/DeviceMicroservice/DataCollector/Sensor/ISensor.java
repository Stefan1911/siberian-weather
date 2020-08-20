package com.MicroserviceApp.DeviceMicroservice.DataCollector.Sensor;

import java.io.IOException;
import java.text.ParseException;

public interface ISensor {
    public Double nextValue() throws IOException, ParseException;
}
