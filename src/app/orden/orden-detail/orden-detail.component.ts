import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';

@Component({
  selector: 'app-orden-detail',
  templateUrl: './orden-detail.component.html',
  styleUrls: ['./orden-detail.component.css']
})
export class OrdenDetailComponent implements OnInit {

  peticion: any = null;
  orden: any = null;
  platos: any = [];

  constructor(private apiRest: ApiRestService, private _route: ActivatedRoute) { }

  ngOnInit(): void {
    this.apiRest.ubicaPorOrden(this._route.snapshot.paramMap.get('id'))
    .subscribe(
      data => {
        this.peticion = data;
        this.orden = this.peticion[0].orden;

        for (var peti of this.peticion)
        {
          this.platos.push(peti.plato);
        }

        this.platos.sort(this.ordenar);
      },
      error => {
        console.log(error.message);
      }
    );
  }

  ordenar(a: any, b: any)
  {
    if(a.categoria.nombre == b.categoria.nombre)
    {
      return 0;
    }
    if (a.categoria.nombre == "Entrante")
    {
      return -1;
    }
    if(a.categoria.nombre == "Primer Plato" && b.categoria.nombre != "Entrante")
    {
      return -1;
    }
    if (a.categoria.nombre == "Segundo Plato" && b.categoria.nombre != "Entrante" && b.categoria.nombre != "Primer Plato")
    {
      return -1;
    }
    return 1;
  }

}
