import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private rol: string | null = '';
  isLoggedIn = false;
  showAdminBoard = false;
  username?: string | null;

  constructor () { }

  ngOnInit(): void
  {
    this.isLoggedIn = !!window.sessionStorage.getItem("auth-token");

    if(this.isLoggedIn)
    {
      this.username = window.sessionStorage.getItem("auth-username");
      this.rol = window.sessionStorage.getItem("auth-rol");

      this.showAdminBoard = (this.rol == 'Administrador');
    }
  }

  logout(): void
  {
    window.sessionStorage.clear();
    window.location.reload();
  }
}
