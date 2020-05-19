package com.MicroserviceApp.DeviceMicroservice.DataController.Sensor;

import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import com.opencsv.CSVReader;
import org.apache.kafka.common.protocol.types.Field;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FileSensor implements ISensor {

    String filePath = "/home/stefan/WorkSpace/siberian-weather/DeviceMicroservice/src/main/resources/weather.csv";
    int columnNumber;
    weatherRunner.WeatherStats stat;
    DecimalFormat decimalFormat = new DecimalFormat();
    char decimalSeparator;
    CSVReader reader;

    public FileSensor(weatherRunner.WeatherStats stat) throws IOException {
        this.stat = stat;
        this.decimalSeparator = ',';
        this.readerSetup();
    }
    public FileSensor(weatherRunner.WeatherStats stat, char decimalSeparator) throws IOException {
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
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(this.decimalSeparator);
        symbols.setGroupingSeparator(' ');
        decimalFormat.setDecimalFormatSymbols(symbols);
        reader = new CSVReader(new FileReader(filePath));
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
