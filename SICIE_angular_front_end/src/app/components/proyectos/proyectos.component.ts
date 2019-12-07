import { Component, OnInit, Input } from '@angular/core';
import { ProyectoInvestigacion } from 'src/app/models/ProyectoInvestigacion';
import { recintoDataService } from '../../Services/data.service';
import { Recinto } from 'src/app/models/Recinto';
import { Router } from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap'


@Component({
  selector: 'ngbd-modal-content',
  template: `
    <div class="modal-header">
      <h4 class="modal-title">Eliminar Proyecto</h4>
    </div>
    <div class="modal-body">
      <p>¿Esta seguro que desea eliminar este proyecto?</p>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-primary" (click)="activeModal.close('Close click')" (click)="eliminarProyecto()">Confirmar</button>
      <button type="button" class="btn btn-light" (click)="activeModal.close('Close click')">Cancelar</button>
    </div>
  `
})
export class NgbdModalContent {
  @Input() proyecto: ProyectoInvestigacion;

  constructor(private service:recintoDataService, public activeModal: NgbActiveModal) {}

  eliminarProyecto() {
    this.service.deleteProyecto(this.proyecto.idProyectoInvestigacion).subscribe(data => {
      console.log(data);
      //this.reloadData();
    },
    error => console.log(error));
  }

}


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

  constructor(private service:recintoDataService, private router: Router, private modalService: NgbModal) {
  }

  ngOnInit() {

    // este arreglo tiene como único fin almacenar las llaves asociadas a cada valor de cada proyecto
    this.columnas = ['codigo', 'titulo', 'docente', 'fechaInicio', 'fechaFinal', 'recinto'];

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

  addNuevo() {
    this.router.navigate(['/addProyecto']);  // define your component where you want to go
  }

  confirmarEliminar(proyecto: ProyectoInvestigacion) {
    const modalRef = this.modalService.open(NgbdModalContent);
    modalRef.componentInstance.proyecto = proyecto;
  }
}
