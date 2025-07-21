import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ProductService } from './product-service';
import { ProductModel } from '../product/product-model';

describe('ProductService (Standalone)', () => {
  let service: ProductService;
  let httpMock: HttpTestingController;

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

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ProductService]
    });

    service = TestBed.inject(ProductService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch product by ID', () => {
    const productId = 1;

    service.getProductById(productId).subscribe((product) => {
      expect(product).toEqual(mockProduct);
    });

    const req = httpMock.expectOne(`http://localhost:8080/v1/products/${productId}`);
    expect(req.request.method).toBe('GET');
    req.flush(mockProduct);
  });

  it('should handle error response', () => {
    const productId = 1;

    service.getProductById(productId).subscribe({
      next: () => fail('Expected an error, not product'),
      error: (error) => {
        expect(error.status).toBe(404);
      }
    });

    const req = httpMock.expectOne(`http://localhost:8080/v1/products/${productId}`);
    req.flush('Product not found', { status: 404, statusText: 'Not Found' });
  });
});
