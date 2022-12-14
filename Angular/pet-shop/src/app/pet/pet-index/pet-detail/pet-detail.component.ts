import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Route } from '@angular/router';
import { Subscription } from 'rxjs';

import { IPet } from '../../model/pet';
import { PetService } from '../../pet.service';

@Component({
  selector: 'app-pet-detail',
  templateUrl: './pet-detail.component.html',
  styleUrls: ['./pet-detail.component.scss'],
})
export class PetDetailComponent implements OnInit, OnDestroy {
  pet: IPet | null=null;
  private subs: Subscription[]=[];

  constructor(private petService: PetService, private route: ActivatedRoute) {}

  ngOnInit(): void{
    this.subs.push()
    this.petService.petsReady$.subscribe(() => {
      this.pet = this.petService.petWithId(this.route.snapshot.params['id']);
    });
     // PARAM: dès que la route change (les params), on récupère la propriété id de ce paramètre
    this.route.params.subscribe((p: any) => {
      this.pet = this.petService.petWithId(p.id);
    });
  }

  ngOnDestroy(): void {
    for (const sub of this.subs) {
      sub.unsubscribe();
    }
    // this.pet = this.petService.petWithId('');
  }
}
