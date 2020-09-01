import { Component, OnInit } from '@angular/core';
import { MicroservicesService } from '../services/microservices.service';
import { ServiceType } from '../models/servicesTypes.model';
import { ServiceInfo } from '../models/microservices.model';
import { element } from 'protractor';

@Component({
  selector: 'app-microservices',
  templateUrl: './microservices.component.html',
  styleUrls: ['./microservices.component.scss']
})
export class MicroservicesComponent implements OnInit {

  public microservices:Map<string,ServiceInfo[] >;

  constructor(private readonly microservicesService: MicroservicesService) {
    this.microservices= new Map<string,ServiceInfo[] >();
   }

  ngOnInit(): void {
    this.microservicesService.getAllMicroservices().subscribe( 
      (service:Map<ServiceType,ServiceInfo[]>) => {
        const map = new Map(Object.entries(service));
        
        map.forEach((value:ServiceInfo[], key)=>{
            this.microservices.set(key, value);
        })
       })
    
  }

}
