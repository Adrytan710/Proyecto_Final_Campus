import { Component, OnInit } from '@angular/core';
import { ApiRestService } from '../_servicios/api-rest.service';
import { UsersService } from '../_servicios/auth/users.service';

@Component({
  selector: 'app-orden',
  templateUrl: './orden.component.html',
  styleUrls: ['./orden.component.css']
})
export class OrdenComponent implements OnInit {

  platos: any = null;
  peticionPlatos = false;
  formCheckbox: any;
  formContador = {
    "Entrante": 0,
    "Primer_Plato": 0,
    "Segundo_Plato": 0,
    "Postre": 0
  };
  platosEnviar: Array<any> = [];
  peticionEnviada = false;
  enviar = false;
  arrayVacio = false;
  ordenFin: any;

  constructor(private api: ApiRestService, private apiUsuario: UsersService) {}

  ngOnInit(): void {
    this.getPlatos();
  }

  getPlatos()
  {
    this.api.getListaPlato().subscribe(
      data => {
        this.peticionPlatos = true;
        this.platos = data;

        this.formCheckbox = [];
        for (const plato of this.platos)
        {
          this.formCheckbox.push(false);
        }
      }
    )
  }

  addPlato(plato: any)
  {
    this.arrayVacio = false;
    const id = plato.id;

    if(this.formCheckbox[id-1])
    {
      this.platosEnviar.push(plato);

      this.addSelecion(plato.categoria.nombre);
    }
    else
    {
      let array = [];
      for (const platoArray of this.platosEnviar)
      {
        if(platoArray.id != id)
        {
          array.push(plato);
        }
      }
      this.platosEnviar = array;
      this.quitarSelecion(plato.categoria.nombre);
    }
  }

  addSelecion(categoria: string)
  {
    switch (categoria)
    {
      case "Entrante":
          this.formContador.Entrante++;
        break;
      case "Primer plato":
          this.formContador.Primer_Plato++;
        break;
      case "Segundo plato":
          this.formContador.Segundo_Plato++;
        break;
      case "Postre":
          this.formContador.Postre++;
        break;
    }
  }

  quitarSelecion(categoria: string)
  {
    switch (categoria)
    {
      case "Entrante":
          this.formContador.Entrante--;
        break;
      case "Primer plato":
          this.formContador.Primer_Plato--;
        break;
      case "Segundo plato":
          this.formContador.Segundo_Plato--;
        break;
      case "Postre":
          this.formContador.Postre--;
        break;
    }
  }

  enviarDatos()
  {
    if(this.platosEnviar.length != 0)
    {
      this.enviar = true;
      const data = {
        fecha: new Date(),
        usuario: ''
      };

      let username: any = window.sessionStorage.getItem('auth-username');

      this.apiUsuario.getUsuario(username)
      .subscribe(
        res => {
          data.usuario = res;

          this.api.agregaElementoOrden(data)
          .subscribe(
            rest => {
              this.api.getListaOrden().subscribe(
                rest2 => {
                  let ordenes: Array<any> | any  = rest2;
                  let orden = ordenes[ordenes.length-1];

                  for (const plato of this.platosEnviar)
                  {
                    this.api.agregaElementoPeticion({orden, plato})
                    .subscribe(
                      resultado => {
                        this.peticionEnviada = true;
                        this.enviar = false;
                      },
                      error => {
                        console.log(error.message);
                      }
                    );
                  }

                  this.ordenFin = orden;
                },
                error => {
                  console.log(error.message);
                }
              );
            },
            error => {
              console.log(error.message);
            }
          );
        }
      );
    }
    else
    {
      this.arrayVacio = true;
    }
  }
}
