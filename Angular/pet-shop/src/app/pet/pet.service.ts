import { Injectable } from '@angular/core';
import { IPet, Species } from './model/pet';

@Injectable({
  providedIn: 'root'
})
export class PetService{
  pets: IPet[] = [];

  selectedPetId: number | null=null;

  get selectedPet(){
    if (!this.pets.some((pet) => pet.id === this.selectedPetId)){
      return null;
    }
    return {...this.pets.find((pet) => pet.id === this.selectedPetId)};
  }

  constructor() {
    this.createPets();
  }

  private createPets(): void {
    const names: string[] = ['milou', 'garfield','nemo','bugs bunny'];
    const speciess: Species[] = ['chien', 'chat','poisson','lapin'];
    const prices: number[] = [500, 400, 10, 50];
    for (let i=0; i<4; i++){
      const pet: IPet = {
        id: i+1,
        name: names[i],
        species: speciess[i],
        price: prices[i],
        isAvailable: i%2 === 0,
      }
      this.pets.push(pet);
    };
  }

  selectPet(petId:number){
    this.selectedPetId = petId;
  }

}
