import { Component, OnInit } from '@angular/core';
import { UsersService } from '../../_servicios/auth/users.service';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-alergias-usuario',
  templateUrl: './alergias-usuario.component.html',
  styleUrls: ['./alergias-usuario.component.css']
})
export class AlergiasUsuarioComponent implements OnInit {

  checkbox : any;
  alergias : any = null;
  alergia : any = null;
  usuario : any = null;

  id : any = null;

  tienen : any = {
    usuario : '',
    alergia : ''
  }
  agregado = false;
  datosRecibidos = false;
  alergys : Array <any> = [];

  constructor(private userServices : UsersService, private restServ : ApiRestService) {}

  ngOnInit(): void {
   this.ubicaUsuarioPorId();
   this.ubicaAlergias();
  }

 ubicaUsuarioPorId() : void {
  this.id = window.sessionStorage.getItem('auth-username');
  this.userServices.ubicaUsuarioPorId(this.id)
    .subscribe (
      respuesta => {
        this.usuario = respuesta;
      },
      error => {
        console.log(error);
      }
    );
 }

 ubicaAlergias() : void {
    this.restServ.getListaAlergias()
      .subscribe (
        datos => {
          this.alergias = datos;
          this.datosRecibidos = true;
          this.checkbox = [];
          for(const alergy of this.alergias) { //CONSTANSTE?
            this.checkbox.push(false);
          }
        },
        error => {
          console.log(error);
        }
      )
 }


 almacenaAlergias(alergy : any) {
   const id = alergy.id;
   if(this.checkbox[id - 1]){
     this.alergys.push(alergy);
   } else {
     let array = [];
     for(const alergyArray of this.alergys) {
       if(alergyArray.id != id) {
        array.push(alergy);
       }
     }
     this.alergys = array;
   }
 }
 guardaNuevoRegistro() : void {
   const registros = {
     usuario : {},
     alergia : {}
   };

    this.id = window.sessionStorage.getItem('auth-username');
    this.userServices.ubicaUsuarioPorId(this.id)
      .subscribe(
        dato => {
        registros.usuario = dato;
        console.log(dato);
       //this.tienen.alergia = 2;
        /*this.restServ.ubicaporIdAlergias(this.tienen.alergia)
           .subscribe(
            datos => {
            console.log(datos);
            registros.alergia = datos;
            console.log(datos);*/
            this.restServ.agregaElementoTieneAlergia(registros)
              .subscribe(
                data => {
                console.log(registros);
                 // console.log(data);
                  //this.agregado = true;

                this.restServ.getListaTieneAlergia()
                    .subscribe(
                      response => {
                        let alerg : Array <any> | any = response;
                        let aler = alerg[alerg.length-1];

                        for(const alergi of this.alergys) {
                          this.restServ.agregaElementoAlergias({aler, alergi})
                            .subscribe(
                              respuesta => {
                                this.agregado = true;
                                },
                              error => {
                                console.log(error);
                              }
                            )
                        }
                      }
                    )

                  },
                  error => {
                    console.log(error);
                  }
             // );
             // }
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
