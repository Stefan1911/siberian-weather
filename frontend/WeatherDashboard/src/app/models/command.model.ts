export class CommandModel {
    constructor(  
        public actuatorType: string,
        public commandDefinitionList: CommandDefinition[]
       ){}
 
}

export interface CommandDefinition {
   arguments:{ 
       argumentType: string, 
       maxValue: number,
       minValue:number
   }[];
   commandName:string;
   description:string;
 
  }