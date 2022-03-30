import { Component, OnInit } from '@angular/core';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';

@Component({
  selector: 'app-add-rol',
  templateUrl: './add-rol.component.html',
  styleUrls: ['./add-rol.component.css']
})
export class AddRolComponent implements OnInit {

  rol : any = {
    nombre : ''
  };
  agregado = false;
  enviar = false;

  constructor(private apiService : ApiRestService) { }

  ngOnInit(): void {
  }

  guardaRegistro() : void {
    this.enviar = true;
    const data = {
      nombre : this.rol.nombre
    };

    this.apiService.agregaElementoRol(data)
      .subscribe(
        respuesta => {
          console.log(respuesta);
          this.agregado = true;
          this.enviar = false;
        },
        error => {
          console.log(error);
        }
      );
  }

  nuevoRegistro() : void {
    this.agregado = false;
    this.rol = {
      nombre : ''
    }
  };

}
