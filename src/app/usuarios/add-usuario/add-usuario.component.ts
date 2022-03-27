import { Component, OnInit } from '@angular/core';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';
import { UsersService } from 'src/app/_servicios/auth/users.service';

@Component({
  selector: 'app-add-usuario',
  templateUrl: './add-usuario.component.html',
  styleUrls: ['./add-usuario.component.css']
})
export class AddUsuarioComponent implements OnInit {

  usuario : any = {
    nombre : '',
    pass_usuario : '',
    email : '',
    rol : ''
  };
  roles: any = null;
  agregado = false;

  constructor(private apiService : UsersService, private api : ApiRestService) { }

  ngOnInit(): void {
    this.api.getListaRol()
    .subscribe(
      data => {
        this.roles = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  guardaRegistro() : void {
    const datos = {
      usuario : this.usuario.nombre,
      pass_usuario : this.usuario.pass_usuario,
      email : this.usuario.email
    };

    this.api.ubicaporIdRol(this.usuario.rol)
    .subscribe(
      data => {
        this.apiService.addUsuario(datos.usuario, datos.pass_usuario, datos.email, data)
        .subscribe(
          respuesta => {
            console.log(respuesta);
            this.agregado = true;
          },
          error => {
            console.log(error);
          }
        );
      }
    );
  }

  nuevoRegistro() : void {
    this.agregado = false;
    this.usuario = {
      nombre : '',
      pass_usuario : '',
      email : '',
      rol : ''
    }
  };

}
