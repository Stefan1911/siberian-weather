import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { BreakpointObserver, Breakpoints } from "@angular/cdk/layout";
import { map, shareReplay } from "rxjs/operators";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  public isHandset$: Observable<boolean>;
  public title:string;
  public showCharts:boolean;

  constructor( private readonly breakpointObserver: BreakpointObserver) {
    this.showCharts=true;
    this.title="Siberia weather" 
    this.isHandset$ = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
      map((result) => result.matches),
      shareReplay()
    );
   }

   public viewCharts():void {
     this.showCharts=!this.showCharts;
   }

  ngOnInit(): void {
  }

}
