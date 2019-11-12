
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class recintoDataService {
  public recinto = new BehaviorSubject<string>('*');
  

  constructor() { }

  editRecinto(newRecinto){
    this.recinto.next(newRecinto);
    console.log('set the ' + newRecinto)
  }

}