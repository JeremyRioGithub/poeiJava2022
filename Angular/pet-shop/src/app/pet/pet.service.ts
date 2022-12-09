import { Injectable, OnInit } from '@angular/core';
import { IPet, Species } from './model/pet';

@Injectable({
  providedIn: 'root'
})
export class PetService implements OnInit{
  private _pets: IPet[] = [];

  private _selectedPetId: number | null=null;

  get pets(){
    return this._pets.map((pet) => {return {...pet};})
  }

  get selectedPet(){
    if (!this._pets.some((pet) => pet.id === this._selectedPetId)){
      return null;
    }
    return {...this.pets.find((pet) => pet.id === this._selectedPetId)};
  }

  constructor() {
    this.createPets();
  }

  ngOnInit(): void {
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
      this._pets.push(pet);
    };
  }
  selectPet(petId:number){
    this._selectedPetId = petId;
  }
  // selectProduct(productId:number){
  //   this._selectedProductId = productId;
  // }


}
