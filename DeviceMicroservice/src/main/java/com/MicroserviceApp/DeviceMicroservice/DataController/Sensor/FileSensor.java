package com.MicroserviceApp.DeviceMicroservice.DataController.Sensor;

import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class FileSensor implements ISensor {
    String fileName = "weather.csv";
    @Autowired
    ResourceLoader resourceLoader;

    int columnNumber;
    weatherRunner.WeatherAttributeType stat;
    DecimalFormat decimalFormat = new DecimalFormat();
    char decimalSeparator;
    CSVReader reader;

    public FileSensor(weatherRunner.WeatherAttributeType stat) throws IOException {
        this.stat = stat;
        this.decimalSeparator = ',';
        this.readerSetup();
    }
    public FileSensor(weatherRunner.WeatherAttributeType stat, char decimalSeparator) throws IOException {
        this.stat = stat;
        this.decimalSeparator = decimalSeparator;
        this.readerSetup();
    }

    private int getColumnNumber() throws IOException {
        String columnName = this.stat.label;
        List<String> Line = Arrays.asList(reader.readNext());
        return Line.indexOf(columnName);
    }


    void readerSetup() throws IOException {
        Resource resource = new ClassPathResource(this.fileName);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(this.decimalSeparator);
        symbols.setGroupingSeparator(' ');
        decimalFormat.setDecimalFormatSymbols(symbols);
        reader = new CSVReader(new FileReader(resource.getFile()));
        this.columnNumber = this.getColumnNumber();
    }

    @Override
    public Double nextValue() throws IOException, ParseException {
        String[] line;
        if ((line = reader.readNext()) == null) {
            this.readerSetup();
            line = reader.readNext();
        }
        Number value = this.decimalFormat.parse(line[this.columnNumber]);
        return value.doubleValue();
    }
}
