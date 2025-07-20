import { Component } from '@angular/core';
import { MatIconModule } from "@angular/material/icon";

@Component({
  selector: 'app-header',
  templateUrl: './header.html',
  styleUrls: ['./header.css'],
  imports: [MatIconModule]
})
export class Header {
  menuItems = [
    'Categories',
    'Offers',
    'Coupons',
    'Supermarket',
    'Fashion',
    'Play Market',
    'Sell',
    'Contact'
  ];
}
