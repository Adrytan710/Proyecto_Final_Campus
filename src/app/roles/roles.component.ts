import { Component, OnInit } from '@angular/core';
import { ApiRestService } from '../_servicios/api-rest.service';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.css']
})
export class RolesComponent implements OnInit {

  roles: any = null;
  peticionRoles = false;

  constructor(private api: ApiRestService) { }

  ngOnInit(): void {
    this.getRoles();
  }

  getRoles()
  {
    this.api.getListaRol().subscribe(
      data => {
        this.peticionRoles = true;
        this.roles = data;
      }
    )
  }

  eliminar(id: string)
  {
    this.api.eliminaElementoRol(id).subscribe(
      data =>
      {
        this.getRoles();
      },
      error =>
      {
        console.log(error.message);
      }
    );
  }
}
