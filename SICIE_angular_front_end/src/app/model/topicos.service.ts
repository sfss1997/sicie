import { Injectable } from '@angular/core';

import { Topico } from './topico';
import { HttpClient , HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class topicosService {

  proyectoUrl:string = 'http://localhost:8080/docentes/api/';

  constructor(private http:HttpClient) { }

  getAllTopicos(): Observable<Topico[]> {
    const url:string = this.proyectoUrl + "listaTopico";
    return this.http.get<Topico[]>(url);
  }
}
