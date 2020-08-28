package com.MicroserviceApp.GatewayService.Gateway.Controllers;

import com.MicroserviceApp.GatewayService.Gateway.DTOs.ActuatorInfoDto;
import com.MicroserviceApp.GatewayService.Gateway.DTOs.CommandServiceInfoDTO;
import com.MicroserviceApp.GatewayService.NameingService.Contracts.INamingService;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceInfo;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceType;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("naming")
public class NamingController {

  @Autowired
  private INamingService namingService;

  @GetMapping(value = "/actuatorInfo")
  public ResponseEntity<ActuatorInfoDto> getActuatorInfo(){
      Optional<ServiceInfo> optionalServiceInfo = namingService.getFirstOrDefaultActuator();

      ActuatorInfoDto responseBody = optionalServiceInfo
          .map(serviceInfo -> ActuatorInfoDto.builder()
              .port(serviceInfo.getPort())
              .ipAddress(serviceInfo.getIpAddress())
              .serviceType(serviceInfo.getServiceType())
              .actuatorType(serviceInfo.getActuatorType())
              .build())
          .orElse(null);
    return new ResponseEntity<>(responseBody, optionalServiceInfo.isPresent() ?  HttpStatus.OK : HttpStatus.NOT_FOUND);
  }
  @GetMapping(value = "/services")
  public Map<ServiceType, Set<ServiceInfo>> getServices(){
    return this.namingService.getAllServices();
  }

  @GetMapping(value = "/commandService")
  public ResponseEntity<CommandServiceInfoDTO> getCommandService(){
    Optional<ServiceInfo> optionalServiceInfo = namingService.getCommandService();

    CommandServiceInfoDTO infoDTO = optionalServiceInfo
        .map(serviceInfo -> {
          return CommandServiceInfoDTO.builder()
              .ipAddress(serviceInfo.getIpAddress())
              .port(serviceInfo.getPort())
              .serviceType(serviceInfo.getServiceType())
              .build();
        })
        .orElse(null);

    return new ResponseEntity<CommandServiceInfoDTO>(infoDTO, optionalServiceInfo.isPresent() ?  HttpStatus.OK : HttpStatus.NOT_FOUND);
  }
}
