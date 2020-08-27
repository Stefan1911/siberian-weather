import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MicroservicesComponent } from './microservices.component';
import {MatTreeModule} from '@angular/material/tree';
import {MatIconModule} from '@angular/material/icon';
import {MatExpansionModule} from '@angular/material/expansion';

@NgModule({
  declarations: [MicroservicesComponent],
  imports: [
    MatTreeModule,
    MatIconModule,
    MatExpansionModule,
    CommonModule
  ],
  exports:[MicroservicesComponent]
})
export class MicroservicesModule { }
