import { Component, OnInit } from '@angular/core';
import { UsersService } from '../_servicios/auth/users.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: any = {
    username: '',
    password: ''
  };
  isLoggedIn = false;
  isLoggin = false;
  isLoginFailed = false;
  errorMessage = '';
  msg = '';
  rol: string | null = '';

  constructor(private usersService: UsersService) { }

  ngOnInit(): void {

    if(window.sessionStorage.getItem("auth-token"))
    {
      this.isLoggedIn = true;
      this.rol = window.sessionStorage.getItem("auth-rol");
      this.login.username = window.sessionStorage.getItem("auth-username");
    }
  }

  logUser(): void {
    this.isLoggin = true;
    this.usersService.login(this.login.username, this.login.password)
      .subscribe(
        response => {

          window.sessionStorage.setItem("auth-token", response.token);
          window.sessionStorage.setItem("auth-username", this.login.username);

          this.isLoginFailed = false;
          this.isLoggin = false;
          this.isLoggedIn = true;

          this.recogerRol();
        },
        error => {
          this.isLoggin = false;
          this.isLoginFailed = true;
          if("Http failure response for https://reserva-restaurant-fe-jai.herokuapp.com/login: 403 OK" == error.message)
          {
            this.errorMessage = 'Usuario y/o Contraseña Incorrectos';
          }
        });
  }

  recogerRol(): void
  {
    this.usersService.getUsuario(this.login.username)
    .subscribe(
      response => {
        window.sessionStorage.setItem("auth-rol", response.rol.nombre);
        window.location.reload();
      },
      error => {
        console.log(error.message);
      }
    );
  }
}
