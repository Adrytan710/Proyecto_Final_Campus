import { Component, OnInit } from '@angular/core';
import { ApiRestService } from 'src/app/_servicios/api-rest.service';

@Component({
  selector: 'app-list-orden',
  templateUrl: './list-orden.component.html',
  styleUrls: ['./list-orden.component.css']
})
export class ListOrdenComponent implements OnInit {

  ordenes: any = null;
  peticionOrdenes = false;

  constructor(private api: ApiRestService) { }

  ngOnInit(): void {
    this.getOrdenes();
  }

  getOrdenes()
  {
    this.api.getListaOrden().subscribe(
      data => {
        this.peticionOrdenes = true;
        this.ordenes = data;
      }
    )
  }

  eliminar(id: string)
  {
    this.api.eliminaElementoOrden(id).subscribe(
      data =>
      {
        this.getOrdenes();
      },
      error =>
      {
        console.log(error.message);
      }
    );
  }

}
