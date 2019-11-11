import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import { DocentesService } from '../model/docentes.service';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Docente } from '../model/docente';

@Component({
  selector: 'app-menu-coordinacion-docentes',
  templateUrl: './menu-coordinacion-docentes.component.html',
  styleUrls: ['./menu-coordinacion-docentes.component.css']
})
export class MenuCoordinacionDocentesComponent implements OnInit {
  displayedColumns = ['id', 'name', 'editar', 'eliminar','estado'];
  dataSource: MatTableDataSource<UserData>;
  private docentes: Docente[] = new Array<Docente>();

  @ViewChild(MatPaginator,{static: false}) paginator: MatPaginator;
  @ViewChild(MatSort,{static: false}) sort: MatSort;

  constructor(private docenteService: DocentesService) {
    // Create 100 users
    const users: UserData[] = [];
    this.docenteService.getAll().subscribe(data => this.docentes=data);
    //for (let i = 1; i <= 100; i++) { users.push(createNewUser(i)); }

    // Assign the data to the data source for the table to render
    //this.dataSource = new MatTableDataSource(users);
  }

  getAll():Docente[]{
    return this.docentes;
  }
  ngOnInit() {
  }

  onSubmit(){
    
  }

  /**
   * Set the paginator and sort after the view init since this component will
   * be able to query its view for the initialized paginator and sort.
   */
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
}

/** Builds and returns a new User. */
function createNewUser(id: number): UserData {
  const name =
      NAMES[Math.round(Math.random() * (NAMES.length - 1))] + ' ' +
      NAMES[Math.round(Math.random() * (NAMES.length - 1))].charAt(0) + '.';

  return {
    id: id.toString(),
    name: name,
    progress: Math.round(Math.random() * 100).toString(),
    color: COLORS[Math.round(Math.random() * (COLORS.length - 1))],
    estado:'activo'
  };
}

/** Constants used to fill up our data base. */
const COLORS = ['maroon', 'red', 'orange', 'yellow', 'olive', 'green', 'purple',
  'fuchsia', 'lime', 'teal', 'aqua', 'blue', 'navy', 'black', 'gray'];
const NAMES = ['Maia', 'Asher', 'Olivia', 'Atticus', 'Amelia', 'Jack',
  'Charlotte', 'Theodore', 'Isla', 'Oliver', 'Isabella', 'Jasper',
  'Cora', 'Levi', 'Violet', 'Arthur', 'Mia', 'Thomas', 'Elizabeth'];

export interface UserData {
  id: string;
  name: string;
  progress: string;
  color: string;
  estado: string;
}