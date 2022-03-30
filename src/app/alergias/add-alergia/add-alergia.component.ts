import { Component, OnInit } from '@angular/core';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';


@Component({
  selector: 'app-add-alergia',
  templateUrl: './add-alergia.component.html',
  styleUrls: ['./add-alergia.component.css']
})
export class AddAlergiaComponent implements OnInit {

  alergia : any = {
    nombre : ''
  };
  agregado = false;
  enviar = false;

  constructor(private alergiaServices : ApiRestService) { }

  ngOnInit(): void {
  }

  guardaRegistro() : void {
    this.enviar = true;
    const data = {
      nombre : this.alergia.nombre
    };

    this.alergiaServices.agregaElementoAlergias(data)
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
    this.alergia = {
      nombre : ''
    }
  };

}
