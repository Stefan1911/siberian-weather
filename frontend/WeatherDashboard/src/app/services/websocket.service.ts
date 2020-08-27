import { Injectable } from "@angular/core";
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { Subject } from 'rxjs';

export enum weatherTypes {
  temperature,
  humidity,
  precipitation,
  pressure,
  visibility,
  waterLevel,
  wind
}

export interface weatherDto{
  wetherType: weatherTypes
  dateTime : Date
  data: number
}

@Injectable({
  providedIn: 'root',
})
export class WebsocketService {
  

  public WeatherSubject : Subject<weatherDto>

  public stompClient;
  constructor() {

    this.WeatherSubject = new Subject();
    this.initializeWebSocketConnection();    
  }

initializeWebSocketConnection() {
    const serverUrl = 'http://localhost:1921/socket';
    const ws = new SockJS(serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this; //this is ugly and i hate it
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe('/message', (message) => {
        if (message.body) {
          that.WeatherSubject.next(message.body);
        }
      });
    });
  }

}