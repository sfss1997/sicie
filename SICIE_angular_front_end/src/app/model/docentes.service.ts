import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/map'
import { Docente } from './docente';

@Injectable()
export class DocentesService {

  private url = 'http://localhost:8080/docentes/api/docente';

  constructor(private http: Http) { }

  getAll():Observable<Docente[]>{
    return  this.http.get(this.url+'/listaDocentes').map(response => response.json());
  }
}
