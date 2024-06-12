import { Component, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { NavbarComponent } from './core/navbar/navbar.component';
import { SidebarComponent } from './core/sidebar/sidebar.component';
import { HomeComponent } from './features/home/home.component';
import { StudioComponent } from './features/studio/studio.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { UserService } from './core/services/api-service/user.service';
import { LoginComponent } from './core/login/login.component';
import { RegisterComponent } from './core/register/register.component';
import { ProductService } from './core/services/api-service/product.service';
import { CartService } from './core/services/api-service/cart.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterModule,
    NavbarComponent,
    SidebarComponent,
    HomeComponent,
    StudioComponent,
    CommonModule,
    HttpClientModule,
    LoginComponent,
    RegisterComponent
  ],
  providers: [UserService, ProductService, CartService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit, OnChanges, OnDestroy {
  title = 'frontend';
  public display = false;
  public userLoggedIn = false;

  private subscriptions = new Subscription();

  constructor(
    private readonly router: Router,
    private readonly userService: UserService
  ) {
  }

  ngOnInit(): void {
    this.userLoggedIn = this.userService.isUserLoggedIn();
  }

  ngOnChanges(changes: SimpleChanges): void {
  }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

}
