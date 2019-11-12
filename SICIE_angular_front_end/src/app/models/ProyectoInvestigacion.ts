import { Recinto } from './Recinto';
import { TipoParticipacionExterna } from './TipoParticipacionExterna';
import { TipoParticipacionInterna } from './TipoParticipacionInterna';

export class ProyectoInvestigacion {
    constructor(public idProyectoInvestigacion: number = 0,
        public codigo: String = "",
        public titulo: String = "",
        public descripcion: String = "",
        public objetivoGeneral: String = "",
        public fechaInicio: Date = new Date(),
        public fechaFinal: Date = new Date(),
        public tipoParticipacionesExternas: TipoParticipacionExterna[] = [],
        public tipoParticipacionesInternas: TipoParticipacionInterna[] = [],
        public recinto: Recinto = new Recinto()) {}

}