import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';

@Component({
  selector: 'app-update-rol',
  templateUrl: './update-rol.component.html',
  styleUrls: ['./update-rol.component.css']
})
export class UpdateRolComponent implements OnInit {

  rol : any = {
    id : '',
    nombre : ''
  };
  recogidaDatos = false;
  actualizado = false;
  enviar = false;

  constructor(private apiService : ApiRestService, private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.apiService.ubicaporIdRol(this.route.snapshot.paramMap.get('id'))
    .subscribe(
      respuesta => {
        this.recogidaDatos = true;
        this.rol = respuesta;
    });
  }

  actualizaRegistro() : void {
    this.enviar = true;
    const data = {
      id : this.rol.id,
      nombre : this.rol.nombre
    };
    this.apiService.actualizaRegistroRol(data.id, data)
      .subscribe(
        response => {
          console.log(response);
          this.enviar = false;
          this.actualizado = true;
        },
        error => {
          console.log(error);
        }
      )
  }

}
