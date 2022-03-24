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

  submitted = false;

  constructor(private usersService: UsersService) { }

  ngOnInit(): void {
  }

  logUser(): void {
    this.usersService.login(this.login.username, this.login.password)
      .subscribe(
        response => {
          this.submitted = true;
          console.log(response);
          window.sessionStorage.setItem("auth-token", response.token);
          window.sessionStorage.setItem("auth-username", this.login.username);
          this.usersService.getUsuario(this.login.username)
          .subscribe(
            response => {
              window.sessionStorage.setItem("auth-rol", response.rol);
            },
            error => {
              console.log(error.message);
            }
          )
        },
        error => {
          console.log(error.message);
        });
  }
}
