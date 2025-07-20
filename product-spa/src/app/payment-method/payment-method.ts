import { Component, Input } from '@angular/core';

interface Resource {
  url: string;
}

interface PaymentMethodEntity {
  type: string;
  friendlyName: string;
  resources: Resource[];
}

@Component({
  selector: 'app-payment-method',
  templateUrl: './payment-method.html',
  styleUrls: ['./payment-method.css']
})
export class PaymentMethod {
  @Input() paymentMethods: PaymentMethodEntity[] = [];
}