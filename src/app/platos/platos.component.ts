import { Component, OnInit } from '@angular/core';
import { ApiRestService } from '../_servicios/api-rest.service';

@Component({
  selector: 'app-platos',
  templateUrl: './platos.component.html',
  styleUrls: ['./platos.component.css']
})
export class PlatosComponent implements OnInit {

  platos: any = null;
  peticionPlatos = false;

  constructor(private api: ApiRestService) { }

  ngOnInit(): void {
    this.getPlatos();
  }

  getPlatos()
  {
    this.api.getListaPlato().subscribe(
      data => {
        this.peticionPlatos = true;
        this.platos = data;

        //this.platos.sort(this.ordenar); Mirar funcionalidad
      }
    )
  }

  eliminar(id: string)
  {
    this.api.eliminaElementoPlato(id).subscribe(
      data =>
      {
        this.getPlatos();
      },
      error =>
      {
        console.log(error.message);
      }
    );
  }

  ordenar(a: any, b: any)
  {
    if(a.categoria.nombre != b.categoria.nombre)
    {
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
      if (a.categoria.nombre == "Postre")
      {
        return 1;
      }
      return 1;
    }
    return 0;
  }
}
