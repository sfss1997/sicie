import { Component, OnInit } from '@angular/core';
import { recintoDataService } from '../Services/data.service';

@Component({
  selector: 'app-menu-coordinacion',
  templateUrl: './menu-coordinacion.component.html',
  styleUrls: ['./menu-coordinacion.component.css']
})


export class MenuCoordinacionComponent implements OnInit {

  message:string;

  constructor(private recintoData: recintoDataService) { }

  ngOnInit() {
    this.recintoData.recinto.subscribe(recinto=> this.message = recinto);
  }

}
