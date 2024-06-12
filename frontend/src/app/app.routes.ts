import { Routes } from '@angular/router';
import { HomeComponent } from './features/home/home.component';
import { ProductListComponent } from './features/products/product-list/product-list.component';
import { ProductDetailComponent } from './features/products/product-detail/product-detail.component';
import { StudioComponent } from './features/studio/studio.component';
import { CartComponent } from './features/cart/cart.component';
import { LoginComponent } from './core/login/login.component';
import { RegisterComponent } from './core/register/register.component';
import { CheckoutComponent } from './features/checkout/checkout.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'products', component: ProductListComponent },
  { path: 'products/:id', component: ProductDetailComponent },
  { path: 'studio', component: StudioComponent },
  { path: 'cart', component: CartComponent },
  { path: 'checkout', component: CheckoutComponent }
];
