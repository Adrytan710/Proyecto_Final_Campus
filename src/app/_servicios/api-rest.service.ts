import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseAPI = 'https://reserva-restaurant-fe-jai.herokuapp.com';

@Injectable({
  providedIn: 'root'
})
export class ApiRestService {

  constructor(private http : HttpClient) { }

  // CRUD ALERGIAS

  getListaAlergias() : Observable <object> {
    return this.http.get<object>(baseAPI);
  }

  ubicaporIdAlergias(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  agregaElementoAlergias(data : any) : Observable <object> {
    return this.http.post(baseAPI, data);
  }

  actualizaRegistroAlergias(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/${id}`, data);
  }

  eliminaElementoAlergias(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/${id}`);
  }

  eliminarRegistrosAlergias() : Observable <object> {
    return this.http.delete(baseAPI);
  }

   // CRUD CATEGORÍA

   getListaCategoria() : Observable <object> {
    return this.http.get<object>(baseAPI);
  }

  ubicaporIdCategoria(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  agregaElementoCategoria(data : any) : Observable <object> {
    return this.http.post(baseAPI, data);
  }

  actualizaRegistroCategoria(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/${id}`, data);
  }

  eliminaElementoCategoria(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/${id}`);
  }

  eliminarRegistrosCategoria() : Observable <object> {
    return this.http.delete(baseAPI);
  }

     // CRUD ORDEN, ANEXO 'UBICA_POR_USER'

  getListaOrden() : Observable <object> {
    return this.http.get<object>(baseAPI);
  }

  ubicaporIdOrden(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  agregaElementoOrden(data : any) : Observable <object> {
    return this.http.post(baseAPI, data);
  }

  actualizaRegistroOrden(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/${id}`, data);
  }

  eliminaElementoOrden(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/${id}`);
  }

  eliminarRegistrosOrden() : Observable <object> {
    return this.http.delete(baseAPI);
  }

  // VERIFICAR YA QUE INTERVIENEN FACTORES A CONTEMPLAR
  ubicaPorUsuario(usuario : string) : Observable <object> {
    return this.http.get(`${baseAPI}/${usuario}`);
  }

  // CRUD PETICIÓN, ANEXO 'UBICA_POR_USER'

  getListaPeticion() : Observable <object> {
    return this.http.get<object>(baseAPI);
  }

  ubicaporIdPeticion(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  agregaElementoPeticion(data : any) : Observable <object> {
    return this.http.post(baseAPI, data);
  }

  actualizaRegistroPeticion(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/${id}`, data);
  }

  eliminaElementoPeticion(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/${id}`);
  }

  eliminarRegistrosPeticion() : Observable <object> {
    return this.http.delete(baseAPI);
  }

  // VERIFICAR YA QUE INTERVIENEN FACTORES A CONTEMPLAR
  ubicaPorOrden(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }
  ubicaPorPlato(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  // REVISAR YA QUE INTERVIENEN 2 TABLAS
}
