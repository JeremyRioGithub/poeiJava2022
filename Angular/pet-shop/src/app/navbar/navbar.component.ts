import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { PetService } from '../pet/pet.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  constructor(private petService: PetService, private auth: AuthService) {}
  get isAuth(){
    return this.auth.isAuth;
  }
  onToggleAuth() {
    this.auth.toggleAuth();
  }
}
