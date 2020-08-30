import { Component, OnInit, OnDestroy } from '@angular/core';
import { WebsocketService, weatherDto } from '../services/websocket.service';
import { weatherTypes } from '../models/weatherTypes.model';
import { Subscription, throwError } from 'rxjs';
import { DatePipe } from '@angular/common';

export class WeatherData {
  constructor(
    public value: number, public name: string){}
}

@Component({
  selector: 'app-chart-dashboard',
  templateUrl: './chart-dashboard.component.html',
  styleUrls: ['./chart-dashboard.component.scss'],
})
export class ChartDashboardComponent implements OnInit , OnDestroy{

  public saleData;
  public weatherData: Map<weatherTypes, { name: String, value: number }[]>;
  public tabs: weatherTypes[];
  
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
  private subscription:Subscription;
  public type : weatherTypes = weatherTypes.temperature
  public realtimeDataConfig = {
    animationDuration: 600,
    numPoints: 20
  };

  colorScheme = {
    domain: [	'#440a4a','#5a0012' ,'#3c3383', '#33bdcd','#fff863','	#fa4616',
    '#fdb5a1','#441e77','#aa6bbf','	#cf7200','#4f61a1','#5646a6','	#fff400','#4afff0',
    '#ffabbc', '	#ff0033', '#aafce8','#f52f21','#f65606']
  };


  dateTickFormatting(value: any): string {
    return this.datepipe.transform(value, 'h:mm:ss');//M/d/yy, 
  }

  constructor( private datepipe: DatePipe, private readonly websocketService: WebsocketService) {
    this.weatherData = new Map<weatherTypes, { name: String, value: number }[]>();
    this.tabs= new Array<weatherTypes>();
  }
  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  ngOnInit(): void { 
    this.subscription=this.websocketService.WeatherSubject.subscribe((weather: weatherDto)=>{
      
      if(this.tabs.indexOf(weather.weatherTypes) === -1){
        this.tabs.push(weather.weatherTypes);
      }
      if(this.weatherData.has(weather.weatherTypes))
        {          
          if(this.tabs.indexOf(weather.weatherTypes) != null)
          this.weatherData.get(weather.weatherTypes).push(new WeatherData(weather.value,this.dateTickFormatting(weather.dateTime)));
          this.weatherData.set(weather.weatherTypes,[...this.weatherData.get(weather.weatherTypes)])
        }
        else{
          let weatherDataArray= new Array<{ name: String, value: number }>();
          weatherDataArray.push(new WeatherData(weather.value,this.dateTickFormatting(weather.dateTime)));
          this.weatherData.set(weather.weatherTypes, weatherDataArray);
        } 
    })
  
  }  

  onSelect(event) {
    console.log(event);
  }
  
}
