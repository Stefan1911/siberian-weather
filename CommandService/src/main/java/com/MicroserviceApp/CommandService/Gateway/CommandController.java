package com.MicroserviceApp.CommandService.Gateway;

import com.MicroserviceApp.CommandService.CommandHandler.Contracts.ICommandHandler;
import com.MicroserviceApp.CommandService.CommandHandler.Models.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("command")
public class CommandController {

  @Autowired
  private ICommandHandler commandHandler;

  @PostMapping
  public ResponseEntity executeCommand(@RequestBody Command command){
    commandHandler.handleCommand(command);
    return new ResponseEntity(HttpStatus.ACCEPTED);
  }

}
