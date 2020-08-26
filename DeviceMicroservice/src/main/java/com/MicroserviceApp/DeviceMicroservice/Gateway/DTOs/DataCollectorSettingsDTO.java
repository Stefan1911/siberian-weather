package com.MicroserviceApp.DeviceMicroservice.Gateway.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DataCollectorSettingsDTO {
  private Integer readRate;
  private Integer batchSize;
}
