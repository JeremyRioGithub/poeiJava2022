import { Component, OnInit, Output } from "@angular/core";

import { IPet, Species } from "./model/pet";

@Component({
  selector: 'app-pet', // convention d'ecriture app-composant
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.scss'],
})
export class PetComponent implements OnInit {
  pets: IPet[] = [];
  selectedPet: IPet | undefined | null=null;

  onSelectPet(petId:number){
    //console.log(petId);
    this.selectedPet = this.pets.find(pet => pet.id === petId);
    //console.log(this.selectedPet);
  }

  ngOnInit(): void {
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
}
