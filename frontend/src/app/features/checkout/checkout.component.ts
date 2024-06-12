import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import {MatExpansionModule} from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css'],
  standalone: true,
  imports: [MatCardModule, MatExpansionModule, MatFormFieldModule, ReactiveFormsModule]
})
export class CheckoutComponent {
  checkoutForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.checkoutForm = this.fb.group({
      billingDetails: this.fb.group({
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        phone: ['', Validators.required]
      }),
      shippingAddress: this.fb.group({
        address: ['', Validators.required],
        city: ['', Validators.required],
        state: ['', Validators.required],
        zip: ['', Validators.required],
      }),
      paymentMethod: this.fb.group({
        cardNumber: ['', Validators.required],
        cardName: ['', Validators.required],
        expirationDate: ['', Validators.required],
        cvv: ['', Validators.required]
      })
    });
  }

  onSubmit() {
    if (this.checkoutForm.valid) {
      console.log('Order placed!', this.checkoutForm.value);
    } else {
      console.log('Form is invalid');
    }
  }
}
