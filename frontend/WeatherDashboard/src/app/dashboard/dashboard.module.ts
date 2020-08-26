import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatButtonModule} from '@angular/material/button';
import { DashboardComponent } from './dashboard.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatIconModule} from '@angular/material/icon';
// import { LayoutModule } from "@angular/cdk/layout";
// import { FlexLayoutModule } from "@angular/flex-layout";
import { RouterModule } from "@angular/router";

@NgModule({
  declarations: [DashboardComponent],
  imports: [
    CommonModule,
    MatSidenavModule,
    MatIconModule,
    MatButtonModule,
    // LayoutModule,
    // FlexLayoutModule,
    RouterModule
    
  ], 
  exports:[DashboardComponent]
})
export class DashboardModule { }
