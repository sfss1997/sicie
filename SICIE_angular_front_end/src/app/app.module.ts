import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { MenuRecintoComponent } from './menu-recinto/menu-recinto.component';
import { MenuCoordinacionComponent } from './menu-coordinacion/menu-coordinacion.component';
import { MenuCoordinacionDocentesComponent } from './menu-coordinacion-docentes/menu-coordinacion-docentes.component';
import { CoordinacionDocentesEditarComponent } from './coordinacion-docentes-editar/coordinacion-docentes-editar.component';
import { CoordinacionDocentesRegistrarComponent } from './coordinacion-docentes-registrar/coordinacion-docentes-registrar.component';
import { NavbarGeneralComponent } from './navbar-general/navbar-general.component';
import { NavbarCoordinacionComponent } from './navbar-coordinacion/navbar-coordinacion.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {HttpClientModule} from '@angular/common/http';
import {CdkTableModule} from '@angular/cdk/table';
import { recintoDataService } from './Services/data.service';
import { DocentesService } from './model/docentes.service';
import { especializacionService } from './model/especializacion.service';
import { topicosService } from './model/topicos.service';

import { ProyectosComponent } from './components/proyectos/proyectos.component';
import { ProyectoItemComponent } from './components/proyecto-item/proyecto-item.component';
import { ProyectoFormComponent } from './components/proyecto-form/proyecto-form.component';
import { DocenteItemTableComponent } from './components/docente-item-table/docente-item-table.component';
import { ParticipanteItemTableComponent } from './components/participante-item-table/participante-item-table.component';
import { NgbdModalContent } from './components/proyectos/proyectos.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {
  MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatStepperModule,
  MatFormFieldModule,
  MatOptionModule,
  
} from '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuRecintoComponent,
    MenuCoordinacionComponent,
    MenuCoordinacionDocentesComponent,
    CoordinacionDocentesEditarComponent,
    CoordinacionDocentesRegistrarComponent,
    NavbarGeneralComponent,
    NavbarCoordinacionComponent,
    ProyectosComponent,
    ProyectoItemComponent,
    ProyectoFormComponent,
    DocenteItemTableComponent,
    ParticipanteItemTableComponent,
    NgbdModalContent
  ],
  exports: [
    CdkTableModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatOptionModule
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    MatTableModule,
    MatDialogModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    HttpClientModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    MatPaginatorModule,
    MatSortModule,
    MatToolbarModule,
    MatOptionModule,
    MatSelectModule,
    NgbModule
  ],
  entryComponents: [
    NgbdModalContent
  ],
  providers: [
    recintoDataService,
    DocentesService,
    especializacionService,
    topicosService
  ],
  bootstrap: [AppComponent],
  
})
export class AppModule { }
platformBrowserDynamic().bootstrapModule(AppModule);