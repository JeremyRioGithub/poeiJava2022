import { Component, OnDestroy, OnInit } from '@angular/core';
import { map, Subscription } from 'rxjs';
import { TimeService } from '../time.service';

@Component({
  selector: 'app-clock',
  templateUrl: './clock.component.html',
  styleUrls: ['./clock.component.scss']
})
export class ClockComponent implements OnInit, OnDestroy {
  displayedTime:string='';
  private sub!: Subscription;

  constructor(private timeService: TimeService){}
  ngOnInit(): void {
    this.sub = (this.timeService.time$
      .pipe(map((date:Date)=>{return 'il est '+ date.getHours() +'heures, '+ date.getMinutes() +' minutes et '+ date.getSeconds() +'secondes.'}))
      .subscribe((formattedDate: string)=>{
        this.displayedTime = formattedDate;
      }));


  }

  ngOnDestroy(): void {
      this.sub.unsubscribe();
  }

}
