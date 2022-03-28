import { Component, OnInit } from '@angular/core';
import { ApiRestService } from '../_servicios/api-rest.service';
import {FormBuilder, FormGroup, FormControl, FormArray} from '@angular/forms';

@Component({
  selector: 'app-orden',
  templateUrl: './orden.component.html',
  styleUrls: ['./orden.component.css']
})
export class OrdenComponent implements OnInit {

  platos: any = null;
  peticionPlatos = false;
  form: FormGroup;

  constructor(private api: ApiRestService, private fb: FormBuilder) {
    this.form = fb.group({
      platosSelecteds:  new FormArray([])
    });
  }

  ngOnInit(): void {
    this.getPlatos();
  }

  getPlatos()
  {
    this.api.getListaPlato().subscribe(
      data => {
        this.peticionPlatos = true;
        this.platos = data;
      }
    )
  }

  onCheckboxChange(event: any) {
    const platosSelecteds = (this.form.value.platosSelecteds as FormArray);
    if (event.target.checked) {
      platosSelecteds.push(new FormControl(event.target.value));
    } else {
      const index = platosSelecteds.controls
      .findIndex(x => x.value === event.target.value);
      platosSelecteds.removeAt(index);
    }
  }

}
