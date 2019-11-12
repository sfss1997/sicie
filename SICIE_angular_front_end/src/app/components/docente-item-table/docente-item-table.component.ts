import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { Docente } from 'src/app/models/Docente';
import { TipoParticipacionInterna } from 'src/app/models/TipoParticipacionInterna';
import { Hito3Service } from '../../services/hito3.service';

@Component({
  selector: '[app-docente-item-table], app-docente-item-table', 
  templateUrl: './docente-item-table.component.html',
  styleUrls: ['./docente-item-table.component.css']
})
export class DocenteItemTableComponent implements OnInit {

  @Output() sendDocenteData = new EventEmitter<TipoParticipacionInterna>(); // emite informacion del docente seleccionado para el componente proyecto-form
  @Input() docente:Docente; // recibe informacion del docente a ser desplegado en una fila de la tabla
  columnas:string[]; // almacena los nombres de las columnas de la tabla de docentes
  tipoParticipacionInterna:TipoParticipacionInterna; // almacena los datos del TipoParticipacionInterna seleccionado
  participaciones:TipoParticipacionInterna[]; // almacena los datos provenientes de la base de datos
  isChecked:boolean; // para controlar si un docente fue seleccionado en la tabla

  constructor(private service:Hito3Service) {}

  ngOnInit() {
    this.columnas = ['nombre','apellidos','correoInstitucional','activo'];

    this.tipoParticipacionInterna = new TipoParticipacionInterna();

    this.service.getAllParticipacionesInternas().subscribe(participaciones => {
      this.participaciones = participaciones;
    });
  }

  addParticipacion() {
    if(this.isChecked){
      this.tipoParticipacionInterna.docente = this.docente;
      this.sendDocenteData.emit(this.tipoParticipacionInterna);
      //console.log('child ' + this.tipoParticipacionInterna.idParticipacion);
    } else {
      this.tipoParticipacionInterna.descripcion = 'eliminar';
      this.sendDocenteData.emit(this.tipoParticipacionInterna);
    }
  }

}
