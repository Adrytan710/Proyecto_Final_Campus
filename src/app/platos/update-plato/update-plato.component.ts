import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';

@Component({
  selector: 'app-update-plato',
  templateUrl: './update-plato.component.html',
  styleUrls: ['./update-plato.component.css']
})
export class UpdatePlatoComponent implements OnInit {

  id: any;
  plato : any = {
    nombre : '',
    categoria: ''
  };
  categorias: any = null;
  agregado = false;

  constructor(private apiService : ApiRestService, private _route: ActivatedRoute) { }

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

    this.id = this._route.snapshot.paramMap.get('id');
    this.apiService.ubicaporIdPlato(this.id)
    .subscribe(
      data => {
        this.plato = data;
        this.plato.categoria = this.plato.categoria.id;
      },
      error => {
        console.log(error.message);
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
        this.apiService.actualizaRegistroPlato(this.id, datos)
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
