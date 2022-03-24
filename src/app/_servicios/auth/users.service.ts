import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const AUTH_API = 'https://reserva-restaurant-fe-jai.herokuapp.com/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }

  login(usuario: string, pass_usuario: string): Observable<any>
  {
    return this.http.post(AUTH_API + 'login', {
      usuario,
      pass_usuario
    }, httpOptions);
  }

  getUsuario(usuario: string): Observable<any>
  {
    return this.http.get(AUTH_API + `usuarios/${usuario}/`, httpOptions);
  }

  getUsuarios(): Observable<any>
  {
    return this.http.get(AUTH_API + `usuarios/`, httpOptions);
  }

  addUsuario(usuario: string, pass_usuario: string, email: string, rol: object): Observable<any>
  {
    return this.http.post(AUTH_API + `usuarios/`, {
      usuario,
      pass_usuario,
      email,
      rol
    }, httpOptions);
  }

  deleteUsuario(id: any): Observable<any>
  {
    return this.http.delete(AUTH_API + `usuarios/${id}/`, httpOptions);
  }
}
