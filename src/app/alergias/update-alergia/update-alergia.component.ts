import { Component, OnInit } from '@angular/core';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-update-alergia',
  templateUrl: './update-alergia.component.html',
  styleUrls: ['./update-alergia.component.css']
})
export class UpdateAlergiaComponent implements OnInit {

  id : any = null;
  alergias : any = null;
  mensaje = '';

  // VERIFICAR LOS MODULOS PARA AGREGAR LAS RESPUESTA DE LOS PATHS !!!
  constructor(
    private alergiaservice : ApiRestService,
    private router : Router,
    private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.alergias.ubicaPorIdAlergia(this.id)
      .subscribe(
        respuesta => {
        this.alergias = respuesta;
      });
  }

  actualizaRegistro() : void {
    this.mensaje = '';
    this.alergiaservice.actualizaRegistroAlergias(this.alergias.id, this.alergias)
      .subscribe(
        response => {
          console.log(response);
        },
        error => {
          console.log(error);
        }
      )
  }

  //MÉTODO QUE ELIMINA EL REGISTRO ESPECÍFICO
  eliminaRegistro() : void {
    this.alergiaservice.eliminaElementoAlergias(this.alergias.id)
      .subscribe(
        respuesta => {
          console.log(respuesta);
          this.router.navigate(['alergias/:id']);
        },
        error => {
          console.log(error);
        }
      );
  }

  //ELIMINA REGISTRO TOTALES Y REENVÍA A LA LISTA GENERAL
  eliminaRegistrosTotales() : void {
    this.alergiaservice.eliminarRegistrosAlergias()
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['alergias']);
        }
      )
  }

}
