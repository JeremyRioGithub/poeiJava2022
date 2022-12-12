import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

import { IPet, Species } from './model/pet';

@Injectable({
  providedIn: 'root',
})
export class PetService {
  private petsUrl =
    'https://formation-6e588-default-rtdb.europe-west1.firebasedatabase.app/pets.json';
  pets: IPet[] = [];
  selectedPet: IPet | undefined | null = null;
  isCreatingPet: boolean = false;

  constructor(private http: HttpClient) {
    this.getPets();
  }

  togglePetCreation(): void {
    this.isCreatingPet = !this.isCreatingPet;
  }

  selectPet(petId: string): void {
    if (this.selectedPet?.id === petId) {
      this.selectedPet = null;
    } else {
      this.selectedPet = this.pets.find((pet) => pet.id === petId);
    }
  }

  // createPet(
  //   name: string,
  //   species: Species,
  //   price: number,
  //   isAvailable: boolean,
  //   imageUrl: string
  // ): void {

  //   const pet: IPet = {
  //     id: maxId + 1,
  //     name,
  //     species,
  //     price,
  //     isAvailable,
  //     imageUrl,
  //   };

  //   this.pets.push(pet);

  //   this.isCreatingPet = false;
  // }

  getPets(): void {
    this.http
      .get(this.petsUrl)
      .pipe(
        map((res: any) => {
          const pets: IPet[] = [];

          for (const key in res) {
            const pet: IPet = {
              id: key,
              // ...res[key],
              name: res[key].name,
              isAvailable: res[key].isAvailable,
              imageUrl: res[key].imageUrl,
              price: res[key].price,
              species: res[key].species,
            };
            pets.push(pet);
          }

          return pets;
        })
      )
      .subscribe((res: IPet[]) => {
        this.pets = res;
      });
  }
}
