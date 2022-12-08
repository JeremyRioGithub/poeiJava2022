import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { IPet } from '../model/pet';

@Component({
  selector: 'app-pet-list',
  templateUrl: './pet-list.component.html',
  styleUrls: ['./pet-list.component.scss']
})
export class PetListComponent implements OnInit {
  @Input() petList: IPet[] = [];
  @Output() selectPet = new EventEmitter<number>();
  constructor(){}
  ngOnInit(): void {}

  onClickPet(petId:number){
    this.selectPet.emit(petId);
    //console.log(petId);
  }
}
