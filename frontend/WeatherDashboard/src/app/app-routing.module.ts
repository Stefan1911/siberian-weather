import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ChartDashboardComponent } from './chart-dashboard/chart-dashboard.component';

const routes: Routes = [
  { path: "", component: DashboardComponent },
  { path: "charts", component: ChartDashboardComponent },
  { path: "**", redirectTo: "" },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }



