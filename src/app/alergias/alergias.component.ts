import { Component, OnInit } from '@angular/core';
import { ApiRestService } from '../_servicios/api-rest.service';

@Component({
  selector: 'app-alergias',
  templateUrl: './alergias.component.html',
  styleUrls: ['./alergias.component.css']
})
export class AlergiasComponent implements OnInit {

  alergias: any = null;
  peticionAlergias = false;

  constructor(private api: ApiRestService) { }

  ngOnInit(): void {
    this.getAlergias();
  }

  getAlergias()
  {
    this.api.getListaAlergias().subscribe(
      data => {
        this.peticionAlergias = true;
        this.alergias = data;
      }
    )
  }

  eliminar(id: string)
  {
    this.api.eliminaElementoAlergias(id).subscribe(
      data =>
      {
        this.getAlergias();
      },
      error =>
      {
        console.log(error.message);
      }
    );
  }

}
