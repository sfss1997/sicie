import { Topico } from "./topico";
import { Especializacion } from "./especializacion";

export class Docente{
    idDocente: number;
    correoInstitucional: String;
    nombre: String;
    apellidos: String;
    gradoAcademico: String;
    topicos: Topico[] = new Array<Topico>();
    especializacion: Especializacion[] = new Array<Especializacion>(); 
    activo: boolean;

    constructor(idDocente?:number,correoInstitucional?:String,nombre?:String,apellidos?:String,gradoAcademico?:String,
        topicos?:Topico[],especializacion?:Especializacion[],activo?:boolean){
            this.idDocente = idDocente;
            this.correoInstitucional = correoInstitucional;
            this.nombre = nombre;
            this.apellidos=apellidos;
            this.gradoAcademico=gradoAcademico;
            this.topicos=topicos;
            this.especializacion=especializacion;
            this.activo = activo;
    }
}