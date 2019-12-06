import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ProyectoInvestigacion } from 'src/app/models/ProyectoInvestigacion';

@Component({
  selector: '[app-proyecto-item], app-proyecto-item',
  templateUrl: './proyecto-item.component.html',
  styleUrls: ['./proyecto-item.component.css']
})
export class ProyectoItemComponent implements OnInit {

  @Output() sendProyectoData = new EventEmitter<ProyectoInvestigacion>(); // emite informacion del proyecto seleccionado para el componente proyecto-form
  @Input() proyectoInvestigacion: ProyectoInvestigacion;
  @Input() columnas: string[];

  docenteACargo:string;
  proyecto:any;
  nombreProyecto:string;

  constructor() {}

  ngOnInit() {

    // ciclo para saber cual de los docentes que participan del proyecto es el encargado
    this.proyectoInvestigacion.tipoParticipacionesInternas.forEach(participacion => {
      if(participacion.descripcion === "Investigador Principal"){
        this.docenteACargo = participacion.docente.nombre + ' ' + participacion.docente.apellidos;
      }
    });

    // se crea un object literal que contenga solo la informacion que se va a mostrar en la tabla
    this.proyecto = {
      codigo: this.proyectoInvestigacion.codigo,
      titulo: this.proyectoInvestigacion.titulo,
      docente: this.docenteACargo,
      descripcion: this.proyectoInvestigacion.descripcion,
      fechaInicio: this.proyectoInvestigacion.fechaInicio,
      fechaFinal: this.proyectoInvestigacion.fechaFinal,
      recinto: this.proyectoInvestigacion.recinto.nombre
    };
  }

  sendProyecto() {
    this.sendProyectoData.emit(this.proyectoInvestigacion);
  }

}
