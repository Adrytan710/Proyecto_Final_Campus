import { Component, OnInit } from '@angular/core';
import { UsersService } from '../../_servicios/auth/users.service';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';

@Component({
  selector: 'app-alergias-usuario',
  templateUrl: './alergias-usuario.component.html',
  styleUrls: ['./alergias-usuario.component.css']
})
export class AlergiasUsuarioComponent implements OnInit {

  usuarios : any = null;
  alergias : any = null;
  usuario : any = null;
  id : any = null;
  tienen : any = {
    usuario : '',
    alergia : ''
  }
  agregado = false;
  datosRecibidos = false;

  constructor(private userServices : UsersService, private restServ : ApiRestService) { }

  ngOnInit(): void {
   this.ubicaUsuarioPorId();
   //this.ubicaAlergias();
   //this.ubicaUsuarios();
  }

 ubicaUsuarioPorId() : void {
  this.id = window.sessionStorage.getItem('auth-username');
  this.userServices.ubicaUsuarioPorId(this.id)
    .subscribe (
      respuesta => {
        this.usuario = respuesta;
        //console.log(respuesta);
      },
      error => {
        console.log(error);
      }
    );
 }

 /*ubicaAlergias() : void {
    this.restServ.getListaAlergias()
      .subscribe (
        datos => {
          this.alergias = datos;
        },
        error => {
          console.log(error);
        }
      )
 }

 ubicaUsuarios() : void {
  this.userServices.getUsuarios()
  .subscribe (
    datos => {
      this.usuarios = datos;
    },
    error => {
      console.log(error);
    }
  );
 }*/

 guardaNuevoRegistro() : void {
   const registros = {
     usuario : {},
     alergia : {}
   };

  // console.log(registro);
    this.id = window.sessionStorage.getItem('auth-username');
    this.userServices.ubicaUsuarioPorId(this.id)
      .subscribe(
        dato => {
        registros.usuario = dato;
        console.log(dato);
        this.restServ.ubicaporIdAlergias(this.tienen.id_alergia)
           .subscribe(
            datos =>{
            registros.alergia = datos;
            console.log(datos);
            this.restServ.agregaElementoTieneAlergia(registros)
              .subscribe(
                data => {
                  console.log(registros);
                  console.log(data);
                  this.agregado = true;
                  },
                  error => {
                    console.log(error);
                  }
              );
              }
            );
        }
      );
 }

 nuevoValor() : void {
   this.agregado = false;
   this.tienen = {
     usuario : '',
     alergia : ''
   }
 }

}
