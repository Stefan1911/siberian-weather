import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.scss']
})
export class NotificationsComponent implements OnInit {
  public dataSource:{notification:string}[];
  public displayedColumns: string[];
 
  constructor() {  
    this.displayedColumns = [
    "Notification"
  ];
  this.dataSource= new Array();
  this.dataSource.push({notification:"notifikacija "});
}

  ngOnInit(): void {
  }

}
