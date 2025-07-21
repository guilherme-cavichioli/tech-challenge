import { Component, Input } from '@angular/core';
import { SellerModel } from './seller-model';

@Component({
  selector: 'app-seller',
  templateUrl: './seller.html',
  styleUrls: ['./seller.css']
})
export class Seller {
  @Input() seller!: SellerModel;
}