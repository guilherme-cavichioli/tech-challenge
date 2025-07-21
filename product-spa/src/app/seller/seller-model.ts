import { PaymentMethodModel } from "../payment-method/payment-method-model";
import { ResourceModel } from "../product/product-model";

export interface SellerModel {
  id: number;
  name: string;
  subtitle: string;
  isOfficial: boolean;
  totalSales: number;
  resource?: ResourceModel;
  paymentMethods?: PaymentMethodModel[];
}