import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { ParticipanteExterno } from 'src/app/models/ParticipanteExterno';
import { TipoParticipacionExterna } from 'src/app/models/TipoParticipacionExterna';
import { Hito3Service } from '../../services/hito3.service';

@Component({
  selector: '[app-participante-item-table]',
  templateUrl: './participante-item-table.component.html',
  styleUrls: ['./participante-item-table.component.css']
})
export class ParticipanteItemTableComponent implements OnInit {

  @Input() participanteExterno:ParticipanteExterno;
  @Output() sendParticipanteData = new EventEmitter<TipoParticipacionExterna>();

  tipoParticipacionesExternas: TipoParticipacionExterna[];
  tipoParticipacionExterna: TipoParticipacionExterna;
  columnas:string[];
  isChecked: boolean;

  constructor(private service:Hito3Service) { }

  ngOnInit() {
    this.tipoParticipacionExterna = new TipoParticipacionExterna();
    this.columnas = ["nombre","apellidos","correoElectronico"];

    this.service.getAllParticipacionesExternas().subscribe(participaciones => {
      this.tipoParticipacionesExternas = participaciones;
    });
  }

  addParticipacion() {
    if(this.isChecked){
      this.tipoParticipacionExterna.participanteExterno = this.participanteExterno;
      this.sendParticipanteData.emit(this.tipoParticipacionExterna);
      //console.log('child ' + this.tipoParticipacionInterna.idParticipacion);
    } else {
      this.tipoParticipacionExterna.descripcion = 'eliminar';
      this.sendParticipanteData.emit(this.tipoParticipacionExterna);
    }
  }

}
