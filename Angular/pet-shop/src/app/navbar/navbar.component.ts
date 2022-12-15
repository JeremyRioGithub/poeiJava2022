import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { PetService } from '../pet/pet.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {

  isAuth: boolean = this.auth.isAuth$.getValue();

  constructor(private petService: PetService, private auth: AuthService) {
    this.auth.isAuth$.subscribe((isAuth) => {this.isAuth = isAuth});
  }

  onToggleAuth() {
    this.auth.toggleAuth();
  }
}
