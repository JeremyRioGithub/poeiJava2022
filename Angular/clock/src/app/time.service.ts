import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TimeService {
time$ = new Subject<Date>();

  constructor() {
    setInterval(()=>{
      this.time$.next(new Date());
    }, 1000);
  }
}
