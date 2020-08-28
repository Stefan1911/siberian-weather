import { Injectable } from "@angular/core";
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { Subject } from 'rxjs';
import { JsonPipe } from '@angular/common';

export enum weatherTypes {
  temperature,
  humidity,
  precipitation,
  pressure,
  visibility,
  waterLevel,
  wind
}

export interface EventDto{
  wetherType: weatherTypes
  dateTime : Date
  data: number
}

@Injectable({
  providedIn: 'root',
})
export class EventWebsocketService {
  

  public EventSubject : Subject<EventDto>

  public stompClient;
  constructor() {

    this.EventSubject = new Subject();
    this.initializeWebSocketConnection();    
  }

initializeWebSocketConnection() {
    const serverUrl = 'http://localhost:1930/socket';
    const ws = new SockJS(serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this; //this is ugly and i hate it
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe('/message', (message) => {
        if (message.body) {
          that.EventSubject.next(JSON.parse( message.body));
        }
      });
    });
  }

}