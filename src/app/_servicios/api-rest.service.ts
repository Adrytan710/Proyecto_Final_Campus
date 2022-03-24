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

  // REVISAR YA QUE INTERVIENEN 2 TABLAS
  // VERIFICAR YA QUE INTERVIENEN FACTORES A CONTEMPLAR
  ubicaPorOrden(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }
  ubicaPorPlato(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  // CRUD PETICIÓN, ANEXO 'UBICA_POR_USER'

  getListaPlato() : Observable <object> {
    return this.http.get<object>(baseAPI);
  }

  ubicaporIdPlato(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  agregaElementoPlato(data : any) : Observable <object> {
    return this.http.post(baseAPI, data);
  }

  actualizaRegistroPlato(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/${id}`, data);
  }

  eliminaElementoPlato(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/${id}`);
  }

  eliminarRegistrosPlato() : Observable <object> {
    return this.http.delete(baseAPI);
  }

  ubicaPorCategoria(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  // CRUD ROL, ANEXO 'UBICA_POR_USER'

  getListaRol() : Observable <object> {
    return this.http.get<object>(baseAPI);
  }

  ubicaporIdRol(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  agregaElementoRol(data : any) : Observable <object> {
    return this.http.post(baseAPI, data);
  }

  actualizaRegistroRol(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/${id}`, data);
  }

  eliminaElementoRol(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/${id}`);
  }

  eliminarRegistrosRol() : Observable <object> {
    return this.http.delete(baseAPI);
  }

  // CRUD PRODUCE_ALERGIA, ANEXO 'UBICA_POR_USER'

  getListaProduceAlergia() : Observable <object> {
    return this.http.get<object>(baseAPI);
  }

  ubicaporIdProduceAlergia(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  agregaElementoProduceAlergia(data : any) : Observable <object> {
    return this.http.post(baseAPI, data);
  }

  actualizaRegistroProduceAlergia(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/${id}`, data);
  }

  eliminaElementoProduceAlergia(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/${id}`);
  }

  eliminarRegistrosProduceAlergia() : Observable <object> {
    return this.http.delete(baseAPI);
  }

  ubicaPorPlatoAlergia(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  // CRUD TIENE_ALERGIA, ANEXO 'UBICA_POR_USER'

  getListaTieneAlergia() : Observable <object> {
    return this.http.get<object>(baseAPI);
  }

  ubicaporIdTieneAlergia(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  agregaElementoTieneAlergia(data : any) : Observable <object> {
    return this.http.post(baseAPI, data);
  }

  actualizaRegistroTieneAlergia(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/${id}`, data);
  }

  eliminaElementoTieneAlergia(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/${id}`);
  }

  eliminarRegistrosTieneAlergia() : Observable <object> {
    return this.http.delete(baseAPI);
  }

  ubicaPorIdAlergia(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/${id}`);
  }

  ubicaPorNombreUsuario(usuario : string) : Observable <object> {
    return this.http.get(`${baseAPI}/${usuario}`);
  }
}
