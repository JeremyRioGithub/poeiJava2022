import { Component, Input, OnInit } from '@angular/core';
import { IPet } from '../model/pet';
import { PetService } from '../pet.service';

@Component({
  selector: 'app-pet-detail',
  templateUrl: './pet-detail.component.html',
  styleUrls: ['./pet-detail.component.scss']
})
export class PetDetailComponent implements OnInit {
  // @Input() detailPet: IPet | undefined | null=null;

  constructor(private petService: PetService){}

  get selectedPet(){
    return this.petService.selectedPet;
  }
  get selectedPetName(){
    return this.petService.selectedPet?.name;
  }

  ngOnInit(): void {
    //console.log(this.chosenPet);
  }

}
