import { Component, OnInit } from '@angular/core';

export interface WeatherData {
  type: String;
  data: { number: number; date: Date }[];
}

@Component({
  selector: 'app-chart-dashboard',
  templateUrl: './chart-dashboard.component.html',
  styleUrls: ['./chart-dashboard.component.scss'],
})
export class ChartDashboardComponent implements OnInit {
  public saleData;
  public weatherData: Array<WeatherData>;

  constructor() {
    this.weatherData = new Array<WeatherData>();
    
    this.saleData = [
      { name: 'Mobiles', value: 105000 },
      { name: 'Laptop', value: 55000 },
      { name: 'AC', value: 15000 },
      { name: 'Headset', value: 150000 },
      { name: 'Fridge', value: 20000 },
    ];
  }

  ngOnInit(): void {}
}
