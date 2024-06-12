import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { HttpClient, HttpClientModule, provideHttpClient } from '@angular/common/http';
import { ProductService } from './core/services/api-service/product.service';
import { UserService } from './core/services/api-service/user.service';
import { CartService } from './core/services/api-service/cart.service';
import { StudioService } from './core/services/api-service/studio.service';

export const AppConfig: ApplicationConfig = {
  providers: [provideRouter(routes), provideHttpClient(), importProvidersFrom(UserService, CartService, StudioService, ProductService)]
};
