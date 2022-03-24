import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private router: Router) { }

  canActivate()
  {
    const token = window.sessionStorage.getItem("auth-token");
    if(!token)
    {
      this.router.navigate(['login']);
    }
    return true;
  }
}
