import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // isAuth: boolean = false;
  isAuth$ = new BehaviorSubject<boolean>(false);

  constructor(private router: Router) { }

  toggleAuth(){
    // this.isAuth = !this.isAuth;
    // if (!this.isAuth)
    //   {this.router.navigate(['home']);}

    this.isAuth$.next(!this.isAuth$.getValue());
    if (!this.isAuth$.getValue())
      {this.router.navigate(['home']);}
  }
}
