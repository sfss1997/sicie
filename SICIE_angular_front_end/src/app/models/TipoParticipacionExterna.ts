import { ParticipanteExterno } from './ParticipanteExterno';

export class TipoParticipacionExterna {
    constructor(public idParticipacion: number = 0,
        public descripcion: String = "",
        public participanteExterno: ParticipanteExterno = null) {}
}