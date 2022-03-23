import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { OrdenComponent } from './orden/orden.component';
import { HomeComponent } from './home/home.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { PlatosComponent } from './platos/platos.component';
import { AlergiasComponent } from './alergias/alergias.component';
import { RolesComponent } from './roles/roles.component';
import { AddRolComponent } from './roles/add-rol/add-rol.component';
import { UpdateRolComponent } from './roles/update-rol/update-rol.component';
import { AddAlergiaComponent } from './alergias/add-alergia/add-alergia.component';
import { UpdateAlergiaComponent } from './alergias/update-alergia/update-alergia.component';
import { AddPlatoComponent } from './platos/add-plato/add-plato.component';
import { UpdatePlatoComponent } from './platos/update-plato/update-plato.component';
import { AddUsuarioComponent } from './usuarios/add-usuario/add-usuario.component';
import { UpdateUsuarioComponent } from './usuarios/update-usuario/update-usuario.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AlergiasUsuarioComponent } from './usuarios/alergias-usuario/alergias-usuario.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    OrdenComponent,
    HomeComponent,
    UsuariosComponent,
    PlatosComponent,
    AlergiasComponent,
    RolesComponent,
    AddRolComponent,
    UpdateRolComponent,
    AddAlergiaComponent,
    UpdateAlergiaComponent,
    AddPlatoComponent,
    UpdatePlatoComponent,
    AddUsuarioComponent,
    UpdateUsuarioComponent,
    AlergiasUsuarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
