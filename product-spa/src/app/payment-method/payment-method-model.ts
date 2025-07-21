import { ResourceModel } from "../product/product-model";

export interface PaymentMethodModel {
  id: number;
  friendlyName: string;
  type: 'CARD' | 'PIX' | 'MERCADO_PAGO';
  resources: ResourceModel[];
}