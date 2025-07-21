import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Product } from './product';
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

describe('Product Component', () => {
  let component: Product;
  let fixture: ComponentFixture<Product>;

  const mockProduct = {
    features: [['Color', 'Red'], ['Size', 'M']],
    resources: [
      { isCover: false, url: 'img1.jpg' },
      { isCover: true, url: 'cover.jpg' },
    ],
    rating: '4.3',
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CommonModule],
      declarations: [Product],
    }).compileComponents();

    fixture = TestBed.createComponent(Product);
    component = fixture.componentInstance;
    component.product = structuredClone(mockProduct); // prevent mutation side-effects
    fixture.detectChanges();
  });

  it('should create component', () => {
    expect(component).toBeTruthy();
  });

  it('should set selectedImageUrl to cover image if available', () => {
    expect(component.selectedImageUrl).toBe('cover.jpg');
  });

  it('should parse features correctly from array', () => {
    expect(component.featureList).toEqual([
      { key: 'Color', value: 'Red' },
      { key: 'Size', value: 'M' },
    ]);
  });

  it('should set starArray based on parsed rating (rounded)', () => {
    expect(component.starArray.length).toBe(4);
  });

  it('should change selected image when changeMainImage is called', () => {
    component.changeMainImage('new-image.jpg');
    expect(component.selectedImageUrl).toBe('new-image.jpg');
  });

  describe('parseFeatures()', () => {
    it('should handle JSON stringified array', () => {
      const input = JSON.stringify([['Material', 'Cotton']]);
      const result = (component as any).parseFeatures(input);
      expect(result).toEqual([{ key: 'Material', value: 'Cotton' }]);
    });

    it('should handle object input', () => {
      const input = { Brand: 'Nike', Country: 'Brazil' };
      const result = (component as any).parseFeatures(input);
      expect(result).toEqual([
        { key: 'Brand', value: 'Nike' },
        { key: 'Country', value: 'Brazil' },
      ]);
    });

    it('should return empty array for invalid JSON string', () => {
      const input = '{"invalidJson": true'; // malformed
      const result = (component as any).parseFeatures(input);
      expect(result).toEqual([]);
    });

    it('should return empty array for null input', () => {
      const result = (component as any).parseFeatures(null);
      expect(result).toEqual([]);
    });
  });
});
