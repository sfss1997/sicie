import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MenuRecintoComponent } from './menu-recinto/menu-recinto.component';



const routes: Routes = [
  {path: 'login' , component: LoginComponent},
  {path: 'recinto' , component: MenuRecintoComponent},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }