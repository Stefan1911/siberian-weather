import { Component, OnInit } from '@angular/core';
import { CommandsService } from '../services/commands.service';
import { CommandModel, CommandDefinition } from '../models/command.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AddCommandModel } from '../models/addCommand.model';

@Component({
  selector: 'app-commands',
  templateUrl: './commands.component.html',
  styleUrls: ['./commands.component.scss']
})
export class CommandsComponent implements OnInit {
  public actuatorType:string;
  public commandDefinitionList: CommandDefinition[];
  public selected;
  public numOfArguments:number;
  public minValues: number[];
  public maxValues:number[];
  public value:number;

  constructor(private readonly commandService: CommandsService, private _snackBar: MatSnackBar) { 
    this.commandDefinitionList= new Array<CommandDefinition>();
    this.numOfArguments=1;
    this.maxValues = new Array<number>();
    this.minValues = new Array<number>();
  }

  ngOnInit(): void {
    this.commandService.getCommands().subscribe( 
      (commands: CommandModel) => {
        console.log(commands);
        this.actuatorType=commands.actuatorType;
        this.commandDefinitionList= commands.commandDefinitionList;
       })
  }

  public onAdd():void{
    if(this.maxValues.length<this.numOfArguments || this.minValues.length!<this.numOfArguments)
      this.openSnackBar('Add all values');
    else
      this.numOfArguments++;
  }

  public onRemove():void{
    if(this.numOfArguments>0)
    {
      this.numOfArguments--;
      this.popMaxElement();
      this.popMinElement();
    }
     
  }


  public onSave():void{
    if(!this.selected)
      this.openSnackBar('Select actuator type');
    else{   
      let newArray=new Array<string>();
      for (let index = 0; index < this.numOfArguments; index++) {
        newArray.push(''+this.minValues[index]);
        newArray.push(''+this.maxValues[index]);
      }
      
      this.commandService.post(new AddCommandModel(this.selected,newArray)).subscribe(res=>  this.openSnackBar('Command is successfully executed'));
      
    }
      
  }

  public addMin(event):void{
    this.popMinElement();
    this.minValues.push(event);
  }

  private popMaxElement(){
    if(this.numOfArguments<=this.maxValues.length){
      this.maxValues.pop();
    }
  }

  private popMinElement(){
    if(this.numOfArguments<=this.minValues.length){
      this.minValues.pop();
    }
  }

  public addMax(event):void{
    this.popMaxElement();
    this.maxValues.push(event);
    console.log(event);
    
    }

  public openSnackBar(message: string) : void { 
      this._snackBar.open(message, null, {
        duration: 2000,
        verticalPosition: 'top',
        panelClass: ['snackbar']
      });
  }
}
