import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-card-container',
  template: `
    <div class="card-container">
      <ng-content></ng-content>
    </div>
  `,
  styleUrls: ['./card-container.css']
})
export class CardContainer {}