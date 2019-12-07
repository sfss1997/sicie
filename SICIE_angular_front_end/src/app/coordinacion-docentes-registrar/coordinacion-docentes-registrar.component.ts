import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { recintoDataService } from '../Services/data.service';
import { topicosService } from '../model/topicos.service';
import { especializacionService} from '../model/especializacion.service';
import { Especializacion } from '../model/especializacion';
import {  Topico } from '../model/topico';
import { Router } from '@angular/router';

@Component({
  selector: 'app-coordinacion-docentes-registrar',
  templateUrl: './coordinacion-docentes-registrar.component.html',
  styleUrls: ['./coordinacion-docentes-registrar.component.css']
})
export class CoordinacionDocentesRegistrarComponent implements OnInit {
  message:string;
  toppings = new FormControl();
  topicos: Topico[];
  especializaciones: Especializacion[];
  toppingList: string[] = ['Inteligencia Artificial', 'Lenguajes', 'Telemática', 'Deep learning', 'Machine Learning', 'Análisis y diseño'];

  constructor(private recintoData: recintoDataService) { }

  ngOnInit() {
    this.recintoData.recinto.subscribe(recinto=> this.message = recinto);
  }

}
