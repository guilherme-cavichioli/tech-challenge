import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-shopping-cart',
  imports: [],
  templateUrl: './shopping-cart.html',
  styleUrl: './shopping-cart.css',
})
export class ShoppingCart {
  @Input() shoppingCart!: { hasStock: boolean };
  @Input() product!: { totalStock: number; [key: string]: any };
}
