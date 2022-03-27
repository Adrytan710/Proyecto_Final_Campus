import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAlergiaComponent } from './alergias/add-alergia/add-alergia.component';
import { AlergiasComponent } from './alergias/alergias.component';
import { UpdateAlergiaComponent } from './alergias/update-alergia/update-alergia.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ListOrdenComponent } from './orden/list-orden/list-orden.component';
import { OrdenDetailComponent } from './orden/orden-detail/orden-detail.component';
import { OrdenComponent } from './orden/orden.component';
import { AddPlatoComponent } from './platos/add-plato/add-plato.component';
import { PlatosComponent } from './platos/platos.component';
import { UpdatePlatoComponent } from './platos/update-plato/update-plato.component';
import { AddRolComponent } from './roles/add-rol/add-rol.component';
import { RolesComponent } from './roles/roles.component';
import { UpdateRolComponent } from './roles/update-rol/update-rol.component';
import { AddUsuarioComponent } from './usuarios/add-usuario/add-usuario.component';
import { AlergiasUsuarioComponent } from './usuarios/alergias-usuario/alergias-usuario.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { AdminGuardService } from './_servicios/auth/admin-guard.service';
import { AuthGuardService } from './_servicios/auth/auth-guard.service';

const routes: Routes = [
  {path:'', component: HomeComponent, canActivate: [AuthGuardService]},
  {path:'home', component: HomeComponent, canActivate: [AuthGuardService]},
  {path:'login', component: LoginComponent},
  {path:'orden', component: OrdenComponent, canActivate: [AuthGuardService]},
  {path:'orden/list', component: ListOrdenComponent, canActivate: [AuthGuardService, AdminGuardService]},
  {path:'orden/:id', component: OrdenDetailComponent, canActivate: [AuthGuardService, AdminGuardService]},
  {path:'profile', component: AlergiasUsuarioComponent, canActivate: [AuthGuardService]},
  {path:'users', component: UsuariosComponent, canActivate: [AuthGuardService, AdminGuardService]},
  {path:'users/add', component: AddUsuarioComponent, canActivate: [AuthGuardService, AdminGuardService]},
  {path:'roles', component: RolesComponent, canActivate: [AuthGuardService, AdminGuardService]},
  {path:'roles/add', component: AddRolComponent, canActivate: [AuthGuardService, AdminGuardService]},
  {path:'roles/:id', component: UpdateRolComponent, canActivate: [AuthGuardService, AdminGuardService]},
  {path:'platos', component: PlatosComponent, canActivate: [AuthGuardService, AdminGuardService]},
  {path:'platos/add', component: AddPlatoComponent, canActivate: [AuthGuardService, AdminGuardService]},
  {path:'platos/:id', component: UpdatePlatoComponent, canActivate: [AuthGuardService, AdminGuardService]},
  {path:'alergias', component: AlergiasComponent, canActivate: [AuthGuardService, AdminGuardService]},
  {path:'alergias/add', component: AddAlergiaComponent, canActivate: [AuthGuardService, AdminGuardService]},
  {path:'alergias/:id', component: UpdateAlergiaComponent, canActivate: [AuthGuardService, AdminGuardService]}//UPDATE
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
