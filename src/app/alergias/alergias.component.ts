import { Component, OnInit } from '@angular/core';
import { ApiRestService } from '../_servicios/api-rest.service';

@Component({
  selector: 'app-alergias',
  templateUrl: './alergias.component.html',
  styleUrls: ['./alergias.component.css']
})
export class AlergiasComponent implements OnInit {

  alergias: object = {};

  constructor(private api: ApiRestService) { }

  ngOnInit(): void {

    this.api.getListaAlergias().subscribe(
      data => {
        console.log(data);
        this.alergias = data;
      }
    )
  }

}
