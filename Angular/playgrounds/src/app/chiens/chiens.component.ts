import { Component, EventEmitter, Input, Output } from "@angular/core";

@Component({
  selector: 'app-chiens', // convention d'ecriture app-OBJET
  templateUrl: './chiens.component.html',
  styleUrls: ['./chiens.component.scss'],
})
export class ChiensComponent {
  @Input() chiens: string[] = []; // @Input permet de récupérer les attributs du parent "app".
  @Output() selectChien = new EventEmitter<string>();
  selectedChien: string|undefined;
  onSelectChiens(chien: string): void{
    console.log(chien);
    this.selectChien.emit(chien);
    this.selectedChien = chien;
  }
};
