import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-microservices',
  templateUrl: './microservices.component.html',
  styleUrls: ['./microservices.component.scss']
})
export class MicroservicesComponent implements OnInit {

  public microservices:[];

  constructor() {
   }

  ngOnInit(): void {
  }

}
