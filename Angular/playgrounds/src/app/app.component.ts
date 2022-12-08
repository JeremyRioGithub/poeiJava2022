import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  //ANIMALS
  title = 'playground';
  favoritePet: string = 'Dogs';
  onChangeFavPet():void {this.favoritePet = 'Cats'}

  //SPORTS
  appSports3: string[] = ['Tir a l\' arc','Boxe thaï']; // liste de string

  //CHIENS
  appChiens: string[] = ['Hachikō','Rintintin','Lassie', 'Beethoven', 'Balto', 'Rantanplan ', 'Croc-Blanc', 'Buck', 'Chaser', 'Laïka']; // liste de string
  chienSelectionne: string | undefined;
  appSelectChien(chien:string){
    this.chienSelectionne = chien;
  }
}
