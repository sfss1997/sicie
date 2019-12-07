import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Especializacion } from './especializacion';

@Injectable({
  providedIn: 'root'
})
export class especializacionService {

  proyectoUrl:string = 'http://localhost:8080/docentes/api/';

  constructor(private http:HttpClient) { }


  getAllEspecializacion(): Observable<Especializacion[]> {
    const url:string = this.proyectoUrl + "listaEspecializacion";
    return this.http.get<Especializacion[]>(url);
  }
}
