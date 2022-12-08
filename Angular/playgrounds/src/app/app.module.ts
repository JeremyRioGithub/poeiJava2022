import { Component, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ChiensComponent } from './chiens/chiens.component';
import { SportComponent } from './sport/sport.component';

@NgModule({
  declarations: [AppComponent, SportComponent, ChiensComponent],
  imports: [BrowserModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
