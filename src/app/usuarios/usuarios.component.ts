import { Component, OnInit } from '@angular/core';
import { ApiRestService } from '../_servicios/api-rest.service';
import { UsersService } from '../_servicios/auth/users.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  usuarios: any = null;
  peticionUsuarios = false;

  constructor(private api: UsersService) { }

  ngOnInit(): void {
    this.getUsuarios();
  }

  getUsuarios()
  {
    this.api.getUsuarios().subscribe(
      data => {
        this.peticionUsuarios = true;
        this.usuarios = data;
      }
    )
  }

  eliminar(id: string)
  {
    this.api.deleteUsuario(id).subscribe(
      data =>
      {
        this.getUsuarios();
      },
      error =>
      {
        console.log(error.message);
        this.getUsuarios();
      }
    );
  }
}
