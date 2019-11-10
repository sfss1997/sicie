import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { recintoDataService } from '../Services/data.service';

@Component({
  selector: 'app-coordinacion-docentes-editar',
  templateUrl: './coordinacion-docentes-editar.component.html',
  styleUrls: ['./coordinacion-docentes-editar.component.css']
})
export class CoordinacionDocentesEditarComponent implements OnInit {

  message:string;
  toppings = new FormControl();
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];

  constructor(private recintoData: recintoDataService) { }

  ngOnInit() {
    this.recintoData.recinto.subscribe(recinto=> this.message = recinto);
  }

}
