import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
  })
export class EventsService{
    constructor(private http: HttpClient ) { }


    getAllEvents() {
        let url: string = "http://localhost:1950/naming/events";
        return this.http.get(url);
    }
}