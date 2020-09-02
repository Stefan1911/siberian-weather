import { Component, OnInit, ViewChild } from '@angular/core';
import { WeatherTypes } from '../models/weatherTypes.model';
import { MatTableDataSource } from '@angular/material/table';
import { DatePipe } from '@angular/common';
import { EventsService } from '../services/event.service';
import { EventWebsocketService, EventDto } from '../services/EventWebSocket.service';
import { MatSort } from '@angular/material/sort';

export class WeatherEvent {
  constructor(
   public weatherTypes : WeatherTypes,
    public dateTime : Date,
    public value :number,
  ){}
}

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.scss']
})
export class NotificationsComponent implements OnInit {
  public dataSource:  MatTableDataSource<WeatherEvent>;
  public displayedColumns: string[];

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private datepipe: DatePipe,private eventsService : EventsService,  eventSocketService :EventWebsocketService) {  
    eventsService.getAllEvents()
    .subscribe( (events: WeatherEvent[]) => {
      let latestEvents = events
      .reverse()
      .slice(0,15);
      this.dataSource = new MatTableDataSource<WeatherEvent>(latestEvents); 
      eventSocketService.EventSubject.subscribe( (event) =>{        
        this.dataSource.data.unshift({weatherTypes : event.weatherTypes,dateTime :event.dateTime,value:event.value});
        if(this.dataSource.data.length > 15){
          this.dataSource.data.pop();
        }
        this.dataSource.data = [...this.dataSource.data];
        this.dataSource.sort = this.sort;
      })
    })    
    this.displayedColumns = ["weatherType" , "value" , "dateTime"];
  }

  dateTickFormatting(value: any): string {
    return this.datepipe.transform(value, 'h:mm:ss');//M/d/yy, 
  }

  ngOnInit(): void {
  
  }

}