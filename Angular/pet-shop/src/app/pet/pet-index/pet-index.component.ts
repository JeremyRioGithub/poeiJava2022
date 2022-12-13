import { Component } from '@angular/core';
import { PetService } from '../pet.service';

@Component({
  selector: 'app-pet-index',
  templateUrl: './pet-index.component.html',
  styleUrls: ['./pet-index.component.scss']
})
export class PetIndexComponent {
  constructor(private petService: PetService){}

  get isCreatingPet(): boolean {
    return this.petService.isCreatingPet;
  }
}
