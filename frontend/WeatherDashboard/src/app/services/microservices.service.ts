import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ServiceType } from '../models/servicesTypes.model';
import { ServiceInfo } from '../models/microservices.model';

@Injectable({
    providedIn: 'root',
  })
export class MicroservicesService{

    constructor(private http: HttpClient ) { }

    getAllMicroservices() : Observable<Map<ServiceType,ServiceInfo[] >>{
        let url: string = "http://localhost:1950/naming/services";
        return this.http.get<Map<ServiceType,ServiceInfo[] >>(url);
    }
}