import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { BreakpointObserver, Breakpoints } from "@angular/cdk/layout";
import { map, shareReplay } from "rxjs/operators";
import { WebsocketService, weatherDto } from '../services/websocket.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  public title:string;
  public showCharts:boolean;
  public showMicroservices:boolean;
  public showNotifications:boolean;
  public showCommands:boolean;

  constructor() {
    this.disableAll();
    this.title="Siberia weather";
   
   }

   public disableAll():void{
    this.showCharts=false;
    this.showMicroservices=false;
    this.showNotifications=false;
    this.showCommands=false;
   }

   public viewCharts():void {
    this.disableAll();
     this.showCharts=!this.showCharts;
   }

   public viewMicroservices():void {
    this.disableAll();
    this.showMicroservices=!this.showMicroservices;
  }

  public viewNotifications():void {
    this.disableAll();
    this.showNotifications=!this.showNotifications;
  }

  public viewCommands():void {
    this.disableAll();
    this.showCommands=!this.showCommands;
  }

  ngOnInit(): void {
  }

}
