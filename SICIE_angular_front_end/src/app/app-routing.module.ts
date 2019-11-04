import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MenuRecintoComponent } from './menu-recinto/menu-recinto.component';
import { MenuCoordinacionComponent } from './menu-coordinacion/menu-coordinacion.component';
import { NavbarGeneralComponent } from './navbar-general/navbar-general.component';




const routes: Routes = [
  {path: 'login' , component: LoginComponent},
  {path: 'recinto' , component: MenuRecintoComponent},
  {path: 'coordinacion' , component:  MenuCoordinacionComponent},
  {path: '' , component:  NavbarGeneralComponent},
 
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }