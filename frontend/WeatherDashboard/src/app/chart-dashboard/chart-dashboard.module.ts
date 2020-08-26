import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChartDashboardComponent } from './chart-dashboard.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import {MatTabsModule} from '@angular/material/tabs';


@NgModule({
  declarations: [ChartDashboardComponent],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    NgxChartsModule,
    MatTabsModule
  ], 
  exports: [ ChartDashboardComponent]
})
export class ChartDashboardModule { }
