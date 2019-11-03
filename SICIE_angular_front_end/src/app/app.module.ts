import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { MenuRecintoComponent } from './menu-recinto/menu-recinto.component';
import { MenuCoordinacionComponent } from './menu-coordinacion/menu-coordinacion.component';
import { MenuCoordinacionDocentesComponent } from './menu-coordinacion-docentes/menu-coordinacion-docentes.component';
import { CoordinacionDocentesRegistroComponent } from './coordinacion-docentes-registro/coordinacion-docentes-registro.component';
import { CoordinacionDocentesEditarComponent } from './coordinacion-docentes-editar/coordinacion-docentes-editar.component';
import { CoordinacionDocentesRegistrarComponent } from './coordinacion-docentes-registrar/coordinacion-docentes-registrar.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuRecintoComponent,
    MenuCoordinacionComponent,
    MenuCoordinacionDocentesComponent,
    CoordinacionDocentesRegistroComponent,
    CoordinacionDocentesEditarComponent,
    CoordinacionDocentesRegistrarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
