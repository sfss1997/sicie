import { Component, OnInit } from '@angular/core';
import { recintoDataService } from '../Services/data.service';


@Component({
  selector: 'app-menu-recinto',
  templateUrl: './menu-recinto.component.html',
  styleUrls: ['./menu-recinto.component.css']
})


export class MenuRecintoComponent implements OnInit {

  message:string;

  constructor(private recintoData: recintoDataService) { }

  ngOnInit() {
   
  }

  setRecinto(recinto){

    this.recintoData.editRecinto(recinto);
    this.recintoData.recinto.subscribe(recinto=> this.message = recinto);

  }

}