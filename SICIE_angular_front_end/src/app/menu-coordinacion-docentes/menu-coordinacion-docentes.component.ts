import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import { recintoDataService } from '../Services/data.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-menu-coordinacion-docentes',
  templateUrl: './menu-coordinacion-docentes.component.html',
  styleUrls: ['./menu-coordinacion-docentes.component.css']
})
export class MenuCoordinacionDocentesComponent  {
  displayedColumns = ['idDocente', 'nombre', 'apellidos', 'editar','eliminar','activo'];
  dataSource: MatTableDataSource<UserData>;
  message:string;
  data:any;
  docentes:any;


  @ViewChild(MatPaginator,{static: false}) paginator: MatPaginator;
  @ViewChild(MatSort,{static: false}) sort: MatSort;

  constructor(private recintoData: recintoDataService, public http: HttpClient) {

    this.data = this.http.get('http://localhost:8080/docentes/api/docente/listaDocentes');
    this.data.subscribe(data => {
      this.docentes = data;
      console.log(this.docentes);

      this.dataSource = new MatTableDataSource(data);
    })

  }

  ngOnInit() {
    this.recintoData.recinto.subscribe(recinto=> this.message = recinto);
  }
  /**
   * Set the paginator and sort after the view init since this component will
   * be able to query its view for the initialized paginator and sort.
   */
  ngAfterViewInit() {
   // this.recintoData.recinto.subscribe(recinto=> this.message = recinto);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
}

  
export interface UserData {
  idDocente: number;
  nombre: string;
  apellidos: string;
  activo: boolean;
}