import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';


@Component({
  selector: 'app-add-alergia',
  templateUrl: './add-alergia.component.html',
  styleUrls: ['./add-alergia.component.css']
})
export class AddAlergiaComponent implements OnInit {

  alergia : any = {
    id : 0,  // VERIFICAR EL NUMBER
    nombre : ''
  };
  agregado = false;

  constructor(private alergiaServices : ApiRestService) { }

  ngOnInit(): void {
  }

  guardaRegistro() : void {
    const data = {
      id : this.alergia.id,
      nombre : this.alergia.nombre
    };

    this.alergiaServices.agregaElementoAlergias(data)
      .subscribe(
        respuesta => {
          console.log(respuesta); //SE PUEDE ELIMINAR
          this.agregado = true;
        },
        error => {
          console.log(error);
        }
      );
  }

  nuevoRegistro() : void {
    this.agregado = false;
    this.alergia = {
      id : 0,
      nombre : ''
    }
  };

}
