import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AdminGuardService implements CanActivate {

  constructor(private router: Router) { }

  canActivate()
  {
    const role = window.sessionStorage.getItem("auth-role");
    if(role != 'Administrador')
    {
      this.router.navigate(['home']);
    }
    return true;
  }
}
