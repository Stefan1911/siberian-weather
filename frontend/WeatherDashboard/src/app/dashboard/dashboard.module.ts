import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule} from '@angular/material/button';
import { DashboardComponent } from './dashboard.component';
import { MatSidenavModule} from '@angular/material/sidenav';
import { MatIconModule} from '@angular/material/icon';
import { RouterModule } from "@angular/router";
import {MatListModule} from '@angular/material/list';
import { ChartDashboardModule } from '../chart-dashboard/chart-dashboard.module';
import { MicroservicesModule } from '../microservices/microservices.module';
import { NotificationsModule } from '../notifications/notifications.module';

@NgModule({
  declarations: [DashboardComponent],
  imports: [
    CommonModule,
    MatSidenavModule,
    MatIconModule,
    MatButtonModule,
    RouterModule,
    MatListModule,
    MicroservicesModule,
    NotificationsModule,
    ChartDashboardModule   
  ], 
  exports:[DashboardComponent]
})
export class DashboardModule { }
