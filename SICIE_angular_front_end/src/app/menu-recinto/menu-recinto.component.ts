import { Component, OnInit } from '@angular/core';
import { recintoDataService } from '../Services/data.service';
import { Recinto } from 'src/app/models/Recinto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-recinto',
  templateUrl: './menu-recinto.component.html',
  styleUrls: ['./menu-recinto.component.css']
})


export class MenuRecintoComponent implements OnInit {
  idRecinto:number;
  recintos:Recinto[];
  message:string;

  constructor(private recintoData: recintoDataService, private router: Router) { }

  ngOnInit() {
    this.recintoData.getAllRecintos().subscribe(recintos => {
      this.recintos = recintos;
    });
  }

  setRecinto(recinto){

    this.recintoData.editRecinto(recinto);
    this.recintoData.recinto.subscribe(recinto=> this.message = recinto);

  }

}