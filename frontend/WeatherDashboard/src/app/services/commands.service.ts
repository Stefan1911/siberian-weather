import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CommandModel } from '../models/command.model';
import { AddCommandModel } from '../models/addCommand.model';

@Injectable({
    providedIn: 'root',
  })
export class CommandsService{

    constructor(private http: HttpClient ) { }

    public getCommands() : Observable<CommandModel>{
        let url: string = "http://localhost:1950/naming/command";
        return this.http.get<CommandModel>(url);
    }

    public post(commandModel: AddCommandModel): Observable<any>{
        let url: string = "http://localhost:1950/naming/command";
        return this.http.post<any>(url,commandModel);
    }
}