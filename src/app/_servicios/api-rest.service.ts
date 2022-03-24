import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const baseURL = 'https://reserva-restaurant-fe-jai.herokuapp.com/api/'

@Injectable({
  providedIn: 'root'
})
export class ApiRestService {

  constructor(private http: HttpClient) { }

  getAllAlergias(): Observable<object>
  {
    return this.http.get<object>(baseURL + 'alergias');
  }
}
