import { Component } from '@angular/core';
import { Product } from './product/product';
import { PaymentMethod } from './payment-method/payment-method';
import { CardContainer } from './shared/card-container/card-container';
import { Seller } from './seller/seller';
import { ShoppingCart } from './shopping-cart/shopping-cart';
import { Header } from './header/header';

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

  product = {
    title: 'Apple iPhone 16 (128 GB)',
    description:
      'iPhone 16 is built for Apple Intelligence and features the power of the A18 chip*. Capture stunning photos with the 48MP Fusion camera. And enjoy more time for texting, browsing, and more with its super-charged battery.',
    features: {
      Display: '6.1 inch AMOLED',
      Battery: '5000mAh',
      Camera: '48 Mpx',
      OS: 'IOS 17',
    },
    resources: [
      { url: 'iphone-cover.jpg', isCover: true },
      { url: 'https://raw.githubusercontent.com/guilherme-cavichioli/tech-challenge/refs/heads/main/fake-storage/resources/product/iphone-back.jpg', isCover: false },
      { url: 'iphone-03.jpg', isCover: false },
      { url: 'iphone-04.jpg', isCover: false },
    ],
    price: '600.00',
    color: 'Black',
    totalStock: 42,
    seller: {
      name: 'Apple',
      subtitle: 'Official Store',
      resource: {
        url: 'apple-banner.png',
      },
      paymentMethods: [
        {
          type: 'PIX',
          friendlyName: 'Pix',
          resources: [{ url: 'pix-logo.png' }],
        },
        {
          type: "CREDIT_CARD",
          friendlyName: 'Credit Card',
          resources: [{ url: 'visa-logo.png' }, { url: 'mastercard-logo.png' }],
        },
        {
          type: 'MERCADO_PAGO',
          friendlyName: 'Mercado Pago',
          resources: [{ url: 'mercado-pago-logo.png' }],
        },
      ],
    },
  };
}
