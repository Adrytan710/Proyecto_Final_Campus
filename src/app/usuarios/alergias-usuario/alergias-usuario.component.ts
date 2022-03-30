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
  usuario: any = '';
  tieneAlergias: any;

  datosGuardados = false;
  datosEnviados = false;
  datosRecibidos = false;
  alergiasEnviar : Array <any> = [];

  constructor(private userServices : UsersService, private restServ : ApiRestService) {}

  ngOnInit(): void
  {
    const id = window.sessionStorage.getItem('auth-username');
    this.userServices.ubicaUsuarioPorId(id)
    .subscribe (
      respuesta => {
        this.usuario = respuesta;
        this.getAlergias();
      },
      error => {
        console.log(error);
      }
    );
  }

  getAlergias() : void
  {
    this.restServ.getListaAlergias()
    .subscribe (
      datos => {
        this.alergias = datos;
        this.datosRecibidos = true;

        this.checkbox = [];
        for(let i = 0; i < this.alergias.lenght; i++)
        {
          this.checkbox.push(false);
        }

        this.restServ.ubicaPorNombreUsuario(this.usuario.usuario)
        .subscribe(
          data => {
            this.tieneAlergias = data;

            for(const alergy of this.tieneAlergias)
            {
              this.checkbox[alergy.alergia.id-1] = true;
              this.alergiasEnviar.push(alergy.alergia);
            }
          }
        );
      },
      error => {
        console.log(error);
      }
    );
  }

  almacenaAlergias(alergy : any)
  {
    this.datosGuardados = false;
    const id = alergy.id;

    if(this.checkbox[id - 1])
    {
      this.alergiasEnviar.push(alergy);
    }
    else
    {
      let array = [];
      for(const alergia of this.alergiasEnviar)
      {
        if(alergia.id != id)
        {
          array.push(alergia);
        }
      }
      this.alergiasEnviar = array;
    }
  }

  guardaNuevoRegistro() : void
  {
    this.datosEnviados = true;

    for (const alergiaAnterior of this.tieneAlergias)
    {
      this.restServ.eliminaElementoTieneAlergia(alergiaAnterior.id)
      .subscribe(
        data => {

        },
        error => {
          console.log(error);
        }
      );
    }

    let usuario = this.usuario;
    for(const alergia of this.alergiasEnviar)
    {
      this.restServ.agregaElementoTieneAlergia({usuario, alergia})
      .subscribe(
        respuesta => {
          this.datosGuardados = true;
          this.datosEnviados = false;
        },
        error => {
          console.log(error);
        }
      );
    }

    if(this.alergiasEnviar.length == 0)
    {
      this.datosGuardados = true;
      this.datosEnviados = false;
    }
  }

}
