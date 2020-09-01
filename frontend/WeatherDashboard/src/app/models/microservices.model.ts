import { ServiceType } from './servicesTypes.model';

export class ServiceInfo {
    constructor( public serviceType:  ServiceType, 
        public ipAddress: string, 
        public port: number,
        public actuatorType: string,
        public weatherAttributeType: string,
        public fullAddress: string  
       ){}
 
  }
   