import { Component, Input } from "@angular/core";

@Component({
  selector: 'app-sport', // convention d'ecriture app-OBJET
  templateUrl: './sport.component.html',
  styleUrls: ['./sport.component.scss'],
})
export class SportComponent {
  sports1: string[] = ['hockey','baseball']; // liste de string
  sports2: {id:number, name:string}[] = [
    {id:1, name:'hockey'},
    {id:2, name:'baseball'}
  ]; // liste d'objets'
  @Input() sports3: string[] = []; // @Input permet de récupérer les attributs du parent "app".
};
