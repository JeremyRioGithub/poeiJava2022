import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'playground';
  favoritePet: string = 'Dogs';
  onChangeFavPet():void {
    this.favoritePet = 'Cats'
  }
}
