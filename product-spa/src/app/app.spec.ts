import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { App } from './app';
import { ProductService } from './services/product-service';
import { of, throwError } from 'rxjs';
import { ProductModel } from './product/product-model';

// Mocks for child components
import { Product } from './product/product';
import { PaymentMethod } from './payment-method/payment-method';
import { CardContainer } from './shared/card-container/card-container';
import { Seller } from './seller/seller';
import { ShoppingCart } from './shopping-cart/shopping-cart';
import { Header } from './header/header';

describe('App Component (Standalone)', () => {
  let component: App;
  let fixture: ComponentFixture<App>;
  let mockProductService: jasmine.SpyObj<ProductService>;

  const mockProduct: ProductModel = {
    title: 'Apple iPhone 16 (128 GB)',
    description:
      'iPhone 16 is built for Apple Intelligence and features the power of the A18 chip*. Capture stunning photos with the 48MP Fusion camera. And enjoy more time for texting, browsing, and more with its super-charged battery.',
    features: '{"Display":"6.1 inch AMOLED","Battery":"5000mAh","Camera":"48 Mpx","OS":"IOS 17"}',
    resources: [
      { id: 1, url: 'iphone-cover.jpg', isCover: true },
      { id: 2, url: 'https://raw.githubusercontent.com/guilherme-cavichioli/tech-challenge/refs/heads/main/fake-storage/resources/product/iphone-back.jpg', isCover: false },
      { id: 3, url: 'iphone-03.jpg', isCover: false },
      { id: 4, url: 'iphone-04.jpg', isCover: false },
    ],
    price: 600.00,
    totalStock: 42,
    seller: {
      id: 1,
      name: 'Apple',
      subtitle: 'Official Store',
      isOfficial: true,
      totalSales: 1000,
      resource: {
        id: 1,
        url: 'apple-banner.png',
        isCover: false,
      },
      paymentMethods: [
        {
          id: 1,
          type: 'PIX',
          friendlyName: 'Pix',
          resources: [{ id: 1, isCover: false, url: 'pix-logo.png' }],
        },
        {
          id: 2,
          type: "CARD",
          friendlyName: 'Credit Card',
          resources: [
            { id: 2, isCover: false, url: 'visa-logo.png' },
            { id: 3, isCover: false, url: 'mastercard-logo.png' }
          ],
        },
        {
          id: 3,
          type: 'MERCADO_PAGO',
          friendlyName: 'Mercado Pago',
          resources: [{ id: 3, isCover: false, url: 'mercado-pago-logo.png' }],
        },
      ],
    },
  } as ProductModel;

  beforeEach(waitForAsync(() => {
    mockProductService = jasmine.createSpyObj('ProductService', ['getProductById']);

    TestBed.configureTestingModule({
      imports: [
        App,
        Product,
        PaymentMethod,
        CardContainer,
        Seller,
        ShoppingCart,
        Header,
      ],
      providers: [{ provide: ProductService, useValue: mockProductService }]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(App);
    component = fixture.componentInstance;
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should call productService.getProductById and assign the product', () => {
    mockProductService.getProductById.and.returnValue(of(mockProduct));

    component.ngOnInit();

    expect(mockProductService.getProductById).toHaveBeenCalledWith(1);
    expect(component.product).toEqual(mockProduct);
  });

  it('should handle error from productService.getProductById', () => {
    const consoleSpy = spyOn(console, 'error');
    mockProductService.getProductById.and.returnValue(throwError(() => new Error('Error')));

    component.ngOnInit();

    expect(mockProductService.getProductById).toHaveBeenCalledWith(1);
    expect(consoleSpy).toHaveBeenCalledWith('Failed to load product', jasmine.any(Error));
    expect(component.product).toBeNull();
  });
});