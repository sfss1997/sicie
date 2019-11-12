import { Docente } from './Docente';

export class TipoParticipacionInterna {
    constructor(public idParticipacion: number = 0,
        public descripcion: String = "",
        public docente: Docente = new Docente()) {}
}