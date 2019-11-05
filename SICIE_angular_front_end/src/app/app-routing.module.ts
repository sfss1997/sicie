import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MenuRecintoComponent } from './menu-recinto/menu-recinto.component';
import { MenuCoordinacionComponent } from './menu-coordinacion/menu-coordinacion.component';
import { NavbarGeneralComponent } from './navbar-general/navbar-general.component';
import { MenuCoordinacionDocentesComponent } from './menu-coordinacion-docentes/menu-coordinacion-docentes.component';
import { CoordinacionDocentesEditarComponent } from './coordinacion-docentes-editar/coordinacion-docentes-editar.component';
import { CoordinacionDocentesRegistrarComponent } from './coordinacion-docentes-registrar/coordinacion-docentes-registrar.component';




const routes: Routes = [
  {path: 'login' , component: LoginComponent},
  {path: 'recinto' , component: MenuRecintoComponent},
  {path: 'coordinacion' , component:  MenuCoordinacionComponent},
  {path: '' , component:  NavbarGeneralComponent},
  {path: 'docentes', component: MenuCoordinacionDocentesComponent},
  {path: 'docentes/editar', component: CoordinacionDocentesEditarComponent},
  {path: 'docentes/registrar', component: CoordinacionDocentesRegistrarComponent}

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }