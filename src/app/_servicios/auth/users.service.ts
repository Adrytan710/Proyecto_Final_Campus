import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const AUTH_API = 'https://reserva-restaurant-fe-jai.herokuapp.com/';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any>
  {
    return this.http.post(AUTH_API + 'login', {
      username,
      password
    });
  }

  getUsuario(username: string): Observable<any>
  {
    return this.http.get(AUTH_API + `usuarios/${username}/`);
  }

  getUsuarios(): Observable<any>
  {
    return this.http.get(AUTH_API + `usuarios/`);
  }

  addUsuario(username: string, password: string, email: string, rol: object): Observable<any>
  {
    return this.http.post(AUTH_API + `usuarios/`, {
      username,
      password,
      email,
      rol
    });
  }

  deleteUsuario(id: any): Observable<any>
  {
    return this.http.delete(AUTH_API + `usuarios/${id}/`);
  }
}
