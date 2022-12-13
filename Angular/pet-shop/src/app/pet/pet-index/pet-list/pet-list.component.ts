import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { IPet } from '../../model/pet';
import { PetService } from '../../pet.service';

@Component({
  selector: 'app-pet-list',
  templateUrl: './pet-list.component.html',
  styleUrls: ['./pet-list.component.scss'],
})
export class PetListComponent implements OnInit {
  constructor(private petService: PetService, private router: Router
    // , private route: ActivatedRoute
    ) {}

  get petList(): IPet[] {
    return this.petService.pets;
  }

  ngOnInit(): void {}

}
