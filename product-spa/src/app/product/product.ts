import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product',
  templateUrl: './product.html',
  styleUrls: ['./product.css'],
  imports: [CommonModule],
})
export class Product {
  @Input() product: any;
  selectedImageUrl: string | undefined;
  featureList: { key: string; value: string }[] = [];
  starArray: number[] = [];

  ngOnInit(): void {
    this.featureList = this.parseFeatures(this.product.features);

    const cover = this.product?.resources?.find((r: any) => r.isCover);
    this.selectedImageUrl = cover
      ? cover.url
      : this.product?.resources?.[0]?.url;

    const ratingValue =
      typeof this.product.rating === 'string'
        ? parseFloat(this.product.rating)
        : this.product.rating;

    let ratingFloat = Math.round(ratingValue ?? 0);
    this.starArray = Array(ratingFloat).fill(0);
  }

  changeMainImage(url: string) {
    this.selectedImageUrl = url;
  }

  private parseFeatures(rawFeatures: any): { key: string; value: string }[] {
    if (Array.isArray(rawFeatures)) {
      return rawFeatures.map(([key, value]: [string, string]) => ({
        key,
        value,
      }));
    } else if (typeof rawFeatures === 'string') {
      try {
        const parsed = JSON.parse(rawFeatures);
        if (Array.isArray(parsed)) {
          return parsed.map(([key, value]: [string, string]) => ({
            key,
            value,
          }));
        }
      } catch (e) {
        console.error('Failed to parse features string:', e);
      }
    } else if (rawFeatures && typeof rawFeatures === 'object') {
      return Object.entries(rawFeatures).map(([key, value]) => ({
        key,
        value: String(value),
      }));
    }

    return [];
  }
}
