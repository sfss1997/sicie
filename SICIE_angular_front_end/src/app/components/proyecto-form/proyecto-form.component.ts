import { Component, OnInit } from '@angular/core';
import { ProyectoInvestigacion } from 'src/app/models/ProyectoInvestigacion';
import { Recinto } from 'src/app/models/Recinto';
import { recintoDataService } from '../../Services/data.service';
import { Docente } from 'src/app/models/Docente';
import { ParticipanteExterno } from 'src/app/models/ParticipanteExterno';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { TipoParticipacionInterna } from 'src/app/models/TipoParticipacionInterna';
import { TipoParticipacionExterna } from 'src/app/models/TipoParticipacionExterna';

@Component({
  selector: 'app-proyecto-form',
  templateUrl: './proyecto-form.component.html',
  styleUrls: ['./proyecto-form.component.css']
})
export class ProyectoFormComponent implements OnInit {

  recintos:Recinto[]; // para desplegar informacion de los recintos en la UI
  proyectoInvestigacion:ProyectoInvestigacion; //almacena informacion del proyecto para luego ser enviado a la BD
  docentes: Docente[]; // para desplegar informacion de los docentes en la UI
  participantesExternos: ParticipanteExterno[]; // para desplegar informacion de los participantes externos en la UI
  participacionesInternasTemp:TipoParticipacionInterna[]; // almacena temporalmente las participaciones internas seleccionadas
  participacionesExternasTemp: TipoParticipacionExterna[];
  participacionesInternas:TipoParticipacionInterna[]; 
  participacionesExternas:TipoParticipacionExterna[];
  docente:Docente; // fuerza bruta ᕦ(ò_ó)ᕤ
  mensaje: string;

  closeResult: string;

  constructor(private service:recintoDataService, private modalService: NgbModal) { }

  ngOnInit() {

    // inicializa las variables
    this.docente = new Docente();
    this.participacionesInternasTemp = [];
    this.participacionesExternasTemp = [];
    //this.proyectoInvestigacion = new ProyectoInvestigacion();
    this.participacionesInternas = [];
    this.participacionesExternas = [];
    this.mensaje = "";

    this.proyectoInvestigacion = this.service.proyectoInvestigacion
    this.participacionesExternas = this.service.proyectoInvestigacion.tipoParticipacionesExternas
    this.participacionesInternas = this.service.proyectoInvestigacion.tipoParticipacionesInternas

    // subscripcion de servicios
    this.service.getAllRecintos().subscribe(recintos => {
      this.recintos = recintos;
    });

    this.service.getAllDocentes().subscribe(docentes => {
      this.docentes = docentes;
    });

    this.service.getAllParticipantesExternos().subscribe(participantes => {
      this.participantesExternos = participantes;
    });
  }

  openXl(content) { 
    this.modalService.open(content, {size: 'xl'}); 
  }

  open(content) {
    this.modalService.open(content, {size: "lg"});
  }

  // seleccionar las participaciones de la tabla de participaciones (docente)
  getTipoParticipacionInterna(tipoParticipacion: TipoParticipacionInterna) { 
    if(tipoParticipacion.descripcion === 'eliminar') {
      for (let index = 0; index < this.participacionesInternasTemp.length; index++) {
        if(this.participacionesInternasTemp[index].idParticipacion === tipoParticipacion.idParticipacion) {
          this.participacionesInternasTemp.splice(index, 1);
        }
      }
    } else {
      this.participacionesInternasTemp.push(tipoParticipacion);
    }
  }

  // seleccionar las participaciones de la tabla de participaciones (participanteExterno)
  getTipoParticipacionExterna(tipoParticipacion: TipoParticipacionExterna) { 
    if(tipoParticipacion.descripcion === 'eliminar') {
      for (let index = 0; index < this.participacionesExternasTemp.length; index++) {
        if(this.participacionesExternasTemp[index].idParticipacion === tipoParticipacion.idParticipacion) {
          this.participacionesExternasTemp.splice(index, 1);
        }
      }
    } else {
      this.participacionesExternasTemp.push(tipoParticipacion);
    }
  }

  // mostrar las participaciones seleccionadas en la tabla del formulario
  agregarParticipacionesInternasSeleccionadas() {
    this.participacionesInternasTemp.forEach(participacion => {
      this.participacionesInternas.push(participacion);
      this.participacionesInternasTemp = []; //se limpia el array temporal
    });
  }

  // mostrar las participaciones seleccionadas en la tabla del formulario
  agregarParticipacionesExternasSeleccionadas() {
    this.participacionesExternasTemp.forEach(participacion => {
      this.participacionesExternas.push(participacion);
      this.participacionesExternasTemp = []; //se limpia el array temporal
    });
  }

  // vacia participacionesInternasTemp en caso de cancelar la seleccion
  limiparSeleccion() {
    this.participacionesInternasTemp = [];
    this.participacionesExternasTemp = [];
  }

  saveProyectoInvestigacion() {
    // Pregunta si se trata de un update 
    if(this.proyectoInvestigacion.idProyectoInvestigacion != 0) {
      this.service.updateProyect(this.proyectoInvestigacion.idProyectoInvestigacion, this.proyectoInvestigacion)
      .subscribe(data => console.log(data), error => console.log(error));
      this.service.unloadProyectData();
    } else {
      const nuevoProyecto: ProyectoInvestigacion = this.proyectoInvestigacion;
      nuevoProyecto.tipoParticipacionesExternas = this.participacionesExternas;
      nuevoProyecto.tipoParticipacionesInternas = this.participacionesInternas;
      this.service.saveProyecto(nuevoProyecto).subscribe(proyecto => {
        this.proyectoInvestigacion = proyecto;
      });
    }
  }

  confirmation(id: number) { 
    if(id != 0) {
      this.mensaje = "El proyecto se guardo satisfactoriamente";
    } else  {
      this.mensaje = "Hubo un error, por favor intentelo de nuevo";
    }
  }

}
