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
    return this.http.get<object>(`${baseAPI}/api/alergias`);
  }

  ubicaporIdAlergias(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/alergias/${id}`);
  }

  agregaElementoAlergias(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/api/alergias/add`, data);
  }

  actualizaRegistroAlergias(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/api/alergias/update/${id}`, data);
  }

  eliminaElementoAlergias(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/api/alergias/delete/${id}`);
  }

  //REVISAR EL POSTMAN SOBRE LA ELIMINACIÓN DE TODOS LOS REGISTROS
  eliminarRegistrosAlergias() : Observable <object> {
    return this.http.delete(`${baseAPI}/api/alergias`);
  }

   // CRUD CATEGORÍA

   getListaCategoria() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/api/categorias`);
  }

  ubicaporIdCategoria(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/categorias/${id}`);
  }

  agregaElementoCategoria(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/api/categorias/add`, data);
  }

  actualizaRegistroCategoria(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/api/categorias/update/${id}`, data);
  }

  eliminaElementoCategoria(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/api/categorias/delete/${id}`);
  }

  eliminarRegistrosCategoria() : Observable <object> {
    return this.http.delete(`${baseAPI}/api/categorias`);  //REVISAR YA QUE NO DISPONEMOS DE LA CONSULTA DEFINIDA EN LA API SPRING YA QUE HARÍA UN DROP TABLE
  }

     // CRUD ORDEN, ANEXO 'UBICA_POR_USER'

  getListaOrden() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/api/ordenes`);
  }

  ubicaporIdOrden(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/ordenes/${id}`);
  }

  agregaElementoOrden(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/api/ordenes/add`, data);
  }

  actualizaRegistroOrden(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/api/ordenes/update/${id}`, data);
  }

  eliminaElementoOrden(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/api/ordenes/delete/${id}`);
  }

  eliminarRegistrosOrden() : Observable <object> {
    return this.http.delete(`${baseAPI}/api/ordenes`);
  }

  // VERIFICAR YA QUE INTERVIENEN FACTORES A CONTEMPLAR
  ubicaPorUsuario(usuario : string) : Observable <object> {
    return this.http.get(`${baseAPI}/api/ordenes/usuario/${usuario}`);
  }

  // CRUD PETICIÓN, ANEXO 'UBICA_POR_USER'

  getListaPeticion() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/api/peticiones`);
  }

  ubicaporIdPeticion(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/peticiones/${id}`);
  }

  agregaElementoPeticion(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/api/peticiones/add`, data);
  }

  actualizaRegistroPeticion(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/api/peticiones/update/${id}`, data);
  }

  eliminaElementoPeticion(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/api/peticiones/delete/${id}`);
  }

  eliminarRegistrosPeticion() : Observable <object> {
    return this.http.delete(`${baseAPI}/api/peticiones`);
  }

  ubicaPorOrden(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/peticiones/orden/${id}`);
  }
  ubicaPorPlato(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/peticiones/plato/${id}`);
  }

  // CRUD PETICIÓN, ANEXO 'UBICA_POR_USER'

  getListaPlato() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/api/platos`);
  }

  ubicaporIdPlato(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/platos/${id}`);
  }

  agregaElementoPlato(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/api/platos/add`, data);
  }

  actualizaRegistroPlato(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/api/platos/update/${id}`, data);
  }

  eliminaElementoPlato(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/api/platos/delete/${id}`);
  }

  eliminarRegistrosPlato() : Observable <object> {
    return this.http.delete(`${baseAPI}/api/platos`);
  }

  ubicaPorCategoria(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/platos/categoria/${id}`);
  }

  // CRUD ROL, ANEXO 'UBICA_POR_USER'

  getListaRol() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/api/roles`);
  }

  ubicaporIdRol(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/roles/${id}`);
  }

  agregaElementoRol(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/api/roles/add`, data);
  }

  actualizaRegistroRol(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/api/roles/update/${id}`, data);
  }

  eliminaElementoRol(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/api/roles/delete/${id}`);
  }

  eliminarRegistrosRol() : Observable <object> {
    return this.http.delete(`${baseAPI}/api/roles`);
  }

  // CRUD PRODUCE_ALERGIA, ANEXO 'UBICA_POR_USER'

  getListaProduceAlergia() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/api/producen`);
  }

  ubicaporIdProduceAlergia(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/producen/${id}`);
  }

  agregaElementoProduceAlergia(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/api/producen/add`, data);
  }

  actualizaRegistroProduceAlergia(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/api/producen/update/${id}`, data);
  }

  eliminaElementoProduceAlergia(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/api/producen/delete/${id}`);
  }

  eliminarRegistrosProduceAlergia() : Observable <object> {
    return this.http.delete(`${baseAPI}/api/producen`);
  }

  ubicaPorPlatoAlergia(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/producen/plato/${id}`);
  }

  // CRUD TIENE_ALERGIA, ANEXO 'UBICA_POR_USER', 'BuscaPorAlergia'

  getListaTieneAlergia() : Observable <object> {
    return this.http.get<object>(`${baseAPI}/api/tienen`);
  }

  ubicaporIdTieneAlergia(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/tienen/${id}`);
  }

  agregaElementoTieneAlergia(data : any) : Observable <object> {
    return this.http.post(`${baseAPI}/api/tienen/add`, data);
  }

  actualizaRegistroTieneAlergia(id : any, data : any) : Observable <object> {
    return this.http.put(`${baseAPI}/api/tienen/update/${id}`, data);
  }

  eliminaElementoTieneAlergia(id : any) : Observable <object> {
    return this.http.delete(`${baseAPI}/api/tienen/delete/${id}`);
  }

  eliminarRegistrosTieneAlergia() : Observable <object> {
    return this.http.delete(`${baseAPI}/api/tienen`);
  }

  ubicaPorIdTieneAlergia(id : any) : Observable <object> {
    return this.http.get(`${baseAPI}/api/tienen/alergia/${id}`);
  }

  ubicaPorNombreUsuario(usuario : string) : Observable <object> {
    return this.http.get(`${baseAPI}/api/tienen/usuario/${usuario}`);
  }
}
