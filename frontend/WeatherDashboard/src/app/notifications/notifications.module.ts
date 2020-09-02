import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationsComponent } from './notifications.component';
import { MatTableModule} from '@angular/material/table';
import { MatInputModule } from "@angular/material/input";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatCardModule} from '@angular/material/card';
import {MatSortModule} from '@angular/material/sort';

@NgModule({
  declarations: [NotificationsComponent],
  imports: [
    CommonModule,
    MatTableModule,
    MatCardModule,
    MatInputModule,
    MatSortModule,
    MatFormFieldModule,
  ],
  exports:[NotificationsComponent]
})
export class NotificationsModule { }
