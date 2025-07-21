import { SellerModel } from "../seller/seller-model";

export interface ProductModel {
  id: number;
  title: string;
  description: string;
  features: string;
  price: number;
  totalStock: number;
  resources?: ResourceModel[];
  seller?: SellerModel;
}

export interface ResourceModel {
  id: number;
  url: string;
  isCover: boolean;
}