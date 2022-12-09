import { Injectable } from '@angular/core';
import { IPet, Species } from './model/pet';

@Injectable({
  providedIn: 'root'
})
export class PetService{
  pets: IPet[] = [];
  selectedPetId: number | null=null;
  isCreatingPet: boolean =false;

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
    const imageUrls: string[] = ['https://cdn001.tintin.com/public/tintin/img/static/milou/milou_v3.png',
    'https://upload.wikimedia.org/wikipedia/en/thumb/b/bc/Garfield_the_Cat.svg/1200px-Garfield_the_Cat.svg.png',
    'https://easydrawingguides.com/wp-content/uploads/2017/05/How-to-Draw-Nemo-20.png',
    'https://img.src.ca/2015/07/27/1250x703/150727_co2q2_aetd_bugs-bunny_sn1250.jpg'];
    for (let i=0; i<4; i++){
      const pet: IPet = {
        id: i+1,
        name: names[i],
        species: speciess[i],
        price: prices[i],
        isAvailable: i%2 === 0,
        imageUrl: imageUrls[i],
      }
      this.pets.push(pet);
    };
  }

  selectPet(petId:number){
    this.selectedPetId = petId;
  }

  togglePetCreation(): void{
    this.isCreatingPet=!this.isCreatingPet;
    //console.log(this.isCreatingpet);
  }

}