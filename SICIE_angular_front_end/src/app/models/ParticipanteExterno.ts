import { EntidadProcedencia } from './EntidadProcedencia';

export class ParticipanteExterno {

    constructor(public idParticipanteExterno: number,
        public nombre: String,
        public apellidos: String,
        public gradoAcademico: String,
        public correoElectronico: String,
        public entidadProcedencia: EntidadProcedencia) {}
}