import { Component, OnInit } from '@angular/core';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';

@Component({
  selector: 'app-add-plato',
  templateUrl: './add-plato.component.html',
  styleUrls: ['./add-plato.component.css']
})
export class AddPlatoComponent implements OnInit {

  plato : any = {
    nombre : '',
    categoria: ''
  };
  categorias: any = null;
  agregado = false;

  constructor(private apiService : ApiRestService) { }

  ngOnInit(): void {
    this.apiService.getListaCategoria()
    .subscribe(
      data => {
        this.categorias = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  guardaRegistro() : void {
    const datos = {
      nombre : this.plato.nombre,
      categoria: {}
    };

    this.apiService.ubicaporIdCategoria(this.plato.categoria)
    .subscribe(
      data => {
        datos.categoria = data;
        this.apiService.agregaElementoPlato(datos)
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
    this.plato = {
      nombre : '',
      categoria: ''
    }
  };

}
