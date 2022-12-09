import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { IPet } from '../model/pet';
import { PetService } from '../pet.service';

@Component({
  selector: 'app-pet-list',
  templateUrl: './pet-list.component.html',
  styleUrls: ['./pet-list.component.scss']
})
export class PetListComponent implements OnInit {
  // @Input() petList: IPet[] = [];
  // @Output() selectPet = new EventEmitter<number>();

  constructor(private petService: PetService){}

  get pets(){
    return this.petService.pets;
  }

  onSelectPet(petId: number){
    console.log("pet-list/onSelectPet: "+petId);
    return this.petService.selectPet(petId);
  }

  ngOnInit(): void {}

  // onClickPet(petId:number){
  //   this.selectPet.emit(petId);
  //   //console.log(petId);
  // }
}
