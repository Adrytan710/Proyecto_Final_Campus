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
    return this.http.get<object>(`${baseAPI}/alergias`);
  }

  ubicaporIdAlergias(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/alergias/${id}`);
  }

  agregaElementoAlergias(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/alergias/add`, data);
  }

  actualizaRegistroAlergias(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/alergias/update/${id}`, data);
  }

  eliminaElementoAlergias(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/alergias/delete/${id}`);
  }

  //REVISAR EL POSTMAN SOBRE LA ELIMINACIÓN DE TODOS LOS REGISTROS
  eliminarRegistrosAlergias() : Observable <object> {
    return this.http.delete(`${baseAPI}/alergias`);
  }

   // CRUD CATEGORÍA

   getListaCategoria() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/categorias`);
  }

  ubicaporIdCategoria(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/categorias/${id}`);
  }

  agregaElementoCategoria(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/categorias/add`, data);
  }

  actualizaRegistroCategoria(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/categorias/update/${id}`, data);
  }

  eliminaElementoCategoria(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/categorias/delete/${id}`);
  }

  eliminarRegistrosCategoria() : Observable <object> {
    return this.http.delete(`${baseAPI}/categorias`);
  }

     // CRUD ORDEN, ANEXO 'UBICA_POR_USER'

  getListaOrden() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/ordenes`);
  }

  ubicaporIdOrden(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/ordenes/${id}`);
  }

  agregaElementoOrden(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/ordenes/add`, data);
  }

  actualizaRegistroOrden(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/ordenes/update/${id}`, data);
  }

  eliminaElementoOrden(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/ordenes/delete/${id}`);
  }

  eliminarRegistrosOrden() : Observable <object> {
    return this.http.delete(`${baseAPI}/ordenes`);
  }

  // VERIFICAR YA QUE INTERVIENEN FACTORES A CONTEMPLAR
  ubicaPorUsuario(usuario : string) : Observable <object> {
    return this.http.get(`${baseAPI}/ordenes/usuario/${usuario}`);
  }

  // CRUD PETICIÓN, ANEXO 'UBICA_POR_USER'

  getListaPeticion() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/peticiones`);
  }

  ubicaporIdPeticion(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/peticiones/${id}`);
  }

  agregaElementoPeticion(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/peticiones/add`, data);
  }

  actualizaRegistroPeticion(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/peticiones/update/${id}`, data);
  }

  eliminaElementoPeticion(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/peticiones/delete/${id}`);
  }

  eliminarRegistrosPeticion() : Observable <object> {
    return this.http.delete(`${baseAPI}/peticiones`);
  }

  ubicaPorOrden(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/peticiones/orden/${id}`);
  }
  ubicaPorPlato(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/peticiones/plato/${id}`);
  }

  // CRUD PETICIÓN, ANEXO 'UBICA_POR_USER'

  getListaPlato() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/platos`);
  }

  ubicaporIdPlato(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/platos/${id}`);
  }

  agregaElementoPlato(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/platos/add`, data);
  }

  actualizaRegistroPlato(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/platos/update/${id}`, data);
  }

  eliminaElementoPlato(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/platos/delete/${id}`);
  }

  eliminarRegistrosPlato() : Observable <object> {
    return this.http.delete(`${baseAPI}/platos`);
  }

  ubicaPorCategoria(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/platos/categoria/${id}`);
  }

  // CRUD ROL, ANEXO 'UBICA_POR_USER'

  getListaRol() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/roles`);
  }

  ubicaporIdRol(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/roles/${id}`);
  }

  agregaElementoRol(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/roles/add`, data);
  }

  actualizaRegistroRol(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/roles/update/${id}`, data);
  }

  eliminaElementoRol(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/roles/delete/${id}`);
  }

  eliminarRegistrosRol() : Observable <object> {
    return this.http.delete(`${baseAPI}/roles`);
  }

  // CRUD PRODUCE_ALERGIA, ANEXO 'UBICA_POR_USER'

  getListaProduceAlergia() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/producen`);
  }

  ubicaporIdProduceAlergia(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/producen/${id}`);
  }

  agregaElementoProduceAlergia(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/producen/add`, data);
  }

  actualizaRegistroProduceAlergia(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/producen/update/${id}`, data);
  }

  eliminaElementoProduceAlergia(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/producen/delete/${id}`);
  }

  eliminarRegistrosProduceAlergia() : Observable <object> {
    return this.http.delete(`${baseAPI}/producen`);
  }

  ubicaPorPlatoAlergia(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/producen/plato/${id}`);
  }

  // CRUD TIENE_ALERGIA, ANEXO 'UBICA_POR_USER', 'BuscaPorAlergia'

  getListaTieneAlergia() : Observable <object> {
    return this.http.get<object>(`${baseAPI}`);
  }

  ubicaporIdTieneAlergia(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/tienen/${id}`);
  }

  agregaElementoTieneAlergia(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/tienen/add`, data);
  }

  actualizaRegistroTieneAlergia(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/tienen/update/${id}`, data);
  }

  eliminaElementoTieneAlergia(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/tienen/delete/${id}`);
  }

  eliminarRegistrosTieneAlergia() : Observable <object> {
    return this.http.delete(`${baseAPI}/tienen`);
  }

  ubicaPorIdAlergia(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/tienen/alergia/${id}`);
  }

  ubicaPorNombreUsuario(usuario : string) : Observable <object> {
    return this.http.get(`${baseAPI}/tienen/usuario/${usuario}`);
  }
}
