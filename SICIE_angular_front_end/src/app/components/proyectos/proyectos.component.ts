import { Component, OnInit } from '@angular/core';
import { ProyectoInvestigacion } from 'src/app/models/ProyectoInvestigacion';
import { Hito3Service } from '../../services/hito3.service';
import { Recinto } from 'src/app/models/Recinto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {

  recintos:Recinto[];
  proyectos:ProyectoInvestigacion[];
  columnas:string[];
  idRecinto:number;
  nombreProyecto:string;
  nombreDocente:string;

  constructor(private service:Hito3Service, private router: Router) {
  }

  ngOnInit() {

    // este arreglo tiene como único fin almacenar las llaves asociadas a cada valor de cada proyecto
    this.columnas = ['codigo', 'titulo', 'docente', 'descripcion', 'fechaInicio', 'fechaFinal', 'recinto'];

    // obtiene todos los proyectos registrados en la base de datos
    this.service.getAllProyectos().subscribe(proyectos => {
      this.proyectos = proyectos;
    });

    // obtiene todos lo recintos registrados en la base de datos
    this.service.getAllRecintos().subscribe(recintos => {
      this.recintos = recintos;
    });
  }

  onSelectRecinto() {
    this.service.getProyectosByIdRecinto(this.idRecinto, this.nombreProyecto, this.nombreDocente).subscribe(proyectos => {
      this.proyectos = proyectos;
    });
  }

  addNuevo(){
    this.router.navigate(['/addProyecto']);  // define your component where you want to go
  }

}
