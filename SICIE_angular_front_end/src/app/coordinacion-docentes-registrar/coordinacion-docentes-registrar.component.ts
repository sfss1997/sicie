import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { recintoDataService } from '../Services/data.service';

@Component({
  selector: 'app-coordinacion-docentes-registrar',
  templateUrl: './coordinacion-docentes-registrar.component.html',
  styleUrls: ['./coordinacion-docentes-registrar.component.css']
})
export class CoordinacionDocentesRegistrarComponent implements OnInit {
  message:string;
  toppings = new FormControl();
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];

  constructor(private recintoData: recintoDataService) { }

  ngOnInit() {
    this.recintoData.recinto.subscribe(recinto=> this.message = recinto);
  }

}
