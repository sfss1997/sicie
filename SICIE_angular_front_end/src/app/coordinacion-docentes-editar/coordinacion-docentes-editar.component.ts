import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-coordinacion-docentes-editar',
  templateUrl: './coordinacion-docentes-editar.component.html',
  styleUrls: ['./coordinacion-docentes-editar.component.css']
})
export class CoordinacionDocentesEditarComponent implements OnInit {

  
  toppings = new FormControl();
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];

  constructor() { }

  ngOnInit() {
  }

}
