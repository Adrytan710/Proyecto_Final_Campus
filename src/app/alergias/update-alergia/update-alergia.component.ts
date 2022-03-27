import { Component, OnInit } from '@angular/core';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-update-alergia',
  templateUrl: './update-alergia.component.html',
  styleUrls: ['./update-alergia.component.css']
})
export class UpdateAlergiaComponent implements OnInit {

  alergia : any = {
    id : '',
    nombre : ''
  };
  recogidaDatos = false;
  actualizado = false;

  constructor(private alergiaservice : ApiRestService, private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.alergiaservice.ubicaporIdAlergias(this.route.snapshot.paramMap.get('id'))
    .subscribe(
      respuesta => {
        this.recogidaDatos = true;
        this.alergia = respuesta;
    });
  }

  actualizaRegistro() : void {
    const data = {
      id : this.alergia.id,
      nombre : this.alergia.nombre
    };
    this.alergiaservice.actualizaRegistroAlergias(data.id, data)
      .subscribe(
        response => {
          console.log(response);
        },
        error => {
          console.log(error);
        }
      )
  }

}
