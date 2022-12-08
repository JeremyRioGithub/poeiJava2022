import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PetComponent } from './pet/pet.component';
import { PetDetailComponent } from './pet/pet-detail/pet-detail.component';
import { PetListComponent } from './pet/pet-list/pet-list.component';
import { PetListItemComponent } from './pet/pet-list/pet-list-item/pet-list-item.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [AppComponent, PetComponent, PetDetailComponent, PetListComponent, PetListItemComponent, NavbarComponent],
  imports: [BrowserModule,AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
