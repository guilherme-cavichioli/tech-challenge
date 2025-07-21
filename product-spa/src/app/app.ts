import { Component } from '@angular/core';
import { Product } from './product/product';
import { PaymentMethod } from './payment-method/payment-method';
import { CardContainer } from './shared/card-container/card-container';
import { Seller } from './seller/seller';
import { ShoppingCart } from './shopping-cart/shopping-cart';
import { Header } from './header/header';
import { ProductService } from './services/product-service';
import { ProductModel } from './product/product-model';

@Component({
  selector: 'app-root',
  imports: [
    Product,
    PaymentMethod,
    CardContainer,
    Seller,
    ShoppingCart,
    Header,
  ],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected title = 'product-spa';
  product: ProductModel | null = null;

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    const productId = 1;
    this.productService.getProductById(productId).subscribe({
      next: (data) => this.product = data,
      error: (err) => console.error('Failed to load product', err)
    });
  }
}
