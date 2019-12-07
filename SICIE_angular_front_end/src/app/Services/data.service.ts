
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

import { Observable } from 'rxjs';
import { HttpClient , HttpHeaders } from '@angular/common/http';
import { ProyectoInvestigacion } from '../models/ProyectoInvestigacion';
import { Recinto } from '../models/Recinto';
import { Docente } from '../models/Docente';
import { TipoParticipacionInterna } from '../models/TipoParticipacionInterna';
import { ParticipanteExterno } from '../models/ParticipanteExterno';
import { TipoParticipacionExterna } from '../models/TipoParticipacionExterna';


@Injectable()
export class recintoDataService {
  public recinto = new BehaviorSubject<string>('*');
  
  proyectoUrl:string = 'http://localhost:8080/docentes/api/';

  proyectoInvestigacion : ProyectoInvestigacion = new ProyectoInvestigacion();

  constructor(private http:HttpClient) { }

  loadProyectData(proyecto: ProyectoInvestigacion) {
    this.proyectoInvestigacion = proyecto;
  }

  unloadProyectData() {
    this.proyectoInvestigacion = new ProyectoInvestigacion();
  }

  editRecinto(newRecinto){
    this.recinto.next(newRecinto);
    console.log('set the ' + newRecinto)
  }

  deleteProyecto(id: number): Observable<any> {
    const url:string = this.proyectoUrl + "proyectoInvestigacion";
    return this.http.delete(`${url}/${id}`, { responseType: 'text' });
  }

  updateProyect(id: number, proyecto: ProyectoInvestigacion): Observable<Object> {
    const url:string = this.proyectoUrl + "proyectoInvestigacion";
    return this.http.put(`${url}/${id}`, proyecto);
  }

  saveProyecto(proyectoInvestigacion: ProyectoInvestigacion): Observable<ProyectoInvestigacion> {
    const url:string = this.proyectoUrl + "proyectoInvestigacion/";
    return this.http.post<ProyectoInvestigacion>(url, proyectoInvestigacion)
  } 

  getAllProyectos(): Observable<ProyectoInvestigacion[]> {
    const url:string = this.proyectoUrl + "proyectoInvestigacion/";
    return this.http.get<ProyectoInvestigacion[]>(url);
  }

  getAllRecintos(): Observable<Recinto[]> {
    const url:string = this.proyectoUrl + "recinto/";
    return this.http.get<Recinto[]>(url);
  }

  getAllDocentes(): Observable<Docente[]> {
    const url:string = this.proyectoUrl + "docente/listaDocentes";
    return this.http.get<Docente[]>(url);
  }

  getAllParticipantesExternos(): Observable<ParticipanteExterno[]> {
    const url:string = this.proyectoUrl + "participanteExterno";
    return this.http.get<ParticipanteExterno[]>(url);
  }

  getProyectosByIdRecinto(idRecinto:number = 0, tituloProyecto:string = "", nombreDocente:string = ""): Observable<ProyectoInvestigacion[]> {
    tituloProyecto = (tituloProyecto.length === 0) ? "null": tituloProyecto;
    nombreDocente = (nombreDocente.length === 0) ? "null" : nombreDocente;
    const url:string = this.proyectoUrl + "proyectoInvestigacion/" + idRecinto + "/" + tituloProyecto + "/" + nombreDocente;
    return this.http.get<ProyectoInvestigacion[]>(url);
  }

  getAllParticipacionesInternas(): Observable<TipoParticipacionInterna[]> {
    const url:string = this.proyectoUrl + "docente/participaciones";
    return this.http.get<TipoParticipacionInterna[]>(url);
  }

  getAllParticipacionesExternas(): Observable<TipoParticipacionExterna[]> {
    const url: string = this.proyectoUrl + "participanteExterno/participaciones";
    return this.http.get<TipoParticipacionExterna[]>(url);
  }

}