export class Docente {
    constructor(public idDocente: number = 0, 
        public nombre: String = "", 
        public apellidos: String = "", 
        public gradoAcademico: String = "", 
        public activo: boolean = false, 
        public correoInstitucional: String = "") {}
}