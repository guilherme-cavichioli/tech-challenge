import { Component, Input } from '@angular/core';

interface SellerEntity {
  name: string;
  subtitle: string;
  resource: { url: string };
}

@Component({
  selector: 'app-seller',
  templateUrl: './seller.html',
  styleUrls: ['./seller.css']
})
export class Seller {
  @Input() seller!: SellerEntity;
}