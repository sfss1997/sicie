import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MenuRecintoComponent } from './menu-recinto/menu-recinto.component';
import { MenuCoordinacionComponent } from './menu-coordinacion/menu-coordinacion.component';
import { NavbarGeneralComponent } from './navbar-general/navbar-general.component';
import { MenuCoordinacionDocentesComponent } from './menu-coordinacion-docentes/menu-coordinacion-docentes.component';




const routes: Routes = [
  {path: 'login' , component: LoginComponent},
  {path: 'recinto' , component: MenuRecintoComponent},
  {path: 'coordinacion' , component:  MenuCoordinacionComponent},
  {path: '' , component:  NavbarGeneralComponent},
  {path: 'docentes', component: MenuCoordinacionDocentesComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }