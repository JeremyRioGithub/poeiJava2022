import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

import { IPet } from '../../model/pet';
import { PetService } from '../../pet.service';

@Component({
  selector: 'app-pet-list',
  templateUrl: './pet-list.component.html',
  styleUrls: ['./pet-list.component.scss'],
})
export class PetListComponent implements OnInit {

  petList$: Observable<IPet[]> = this.petService.pets$.asObservable();

  // get petList(): IPet[] {
  //   return this.petService.pets;
  // }

  constructor(private petService: PetService, private router: Router) {}

  ngOnInit(): void {}

}
