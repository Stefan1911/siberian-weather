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
  
  public view: any[] = [1100, 600];
  public showXAxis = true;
  public showYAxis = true;
  public gradient = false;
  public showLegend = true;
  public showXAxisLabel = true;
  public xAxisLabel = 'Date';
  public showYAxisLabel = true;
  public yAxisLabel = 'Value';
  public timeline = true;

  colorScheme = {
    domain: [	'#440a4a','#5a0012' ,'#3c3383', '#33bdcd','#fff863','	#fa4616',
    '#fdb5a1','#441e77','#aa6bbf','	#cf7200','#4f61a1','#5646a6','	#fff400','#4afff0',
    '#ffabbc', '	#ff0033', '#aafce8','#f52f21','#f65606']
  };
  
  constructor() {
    this.weatherData = new Array<WeatherData>();
    this.saleData = [
      { name: 'Mobiles', value: 105000 },
      { name: 'Laptop', value: 55000 },
      { name: 'AC', value: 15000 },
      { name: 'fbg', value: 150000 },
      { name: 'fgb', value: 20000 }, { name: 'fgb', value: 105000 },
      { name: 'Laptop', value: 55000 },
      { name: 'AC', value: 15000 },
      { name: 'Headset', value: 150000 },
      { name: 'Fridge', value: 20000 }, { name: 'bfg', value: 105000 },
      { name: 'Laptop', value: 55000 },
      { name: 'AC', value: 15000 },
      { name: 'Headset', value: 150000 },
      { name: 'Fridge', value: 20000 }, { name: 'fgb', value: 105000 },
      { name: 'Laptop', value: 55000 },
      { name: 'AC', value: 15000 },
      { name: 'Headset', value: 150000 },
      { name: 'sd', value: 20000 }, { name: 'Mobifgbles', value: 105000 },
      { name: 'sd', value: 55000 },
      { name: 'd', value: 15000 },
      { name: 'c', value: 150000 },
      { name: 'Fdcridge', value: 20000 }, { name: 'fgb', value: 105000 },
      { name: 'Laptop', value: 55000 },
      { name: 'AdcC', value: 15000 },
      { name: 'dc', value: 150000 },
      { name: 'hgf', value: 20000 }, { name: 'gbf', value: 105000 },
      { name: 'cds', value: 55000 },
      { name: 'AC', value: 15000 },
      { name: 'bfg', value: 150000 },
      { name: 'Fridge', value: 20000 },
    ];
  }

  ngOnInit(): void { 
  }  

  onSelect(event) {
    console.log(event);
  }
  
}
