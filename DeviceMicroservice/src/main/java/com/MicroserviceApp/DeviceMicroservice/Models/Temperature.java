package com.MicroserviceApp.DeviceMicroservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Temperature {

    private Date date;
    private int value;
}
