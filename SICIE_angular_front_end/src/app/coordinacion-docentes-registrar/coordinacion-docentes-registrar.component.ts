import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-coordinacion-docentes-registrar',
  templateUrl: './coordinacion-docentes-registrar.component.html',
  styleUrls: ['./coordinacion-docentes-registrar.component.css']
})
export class CoordinacionDocentesRegistrarComponent implements OnInit {

  toppings = new FormControl();
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];

  constructor() { }

  ngOnInit() {
  }

}
