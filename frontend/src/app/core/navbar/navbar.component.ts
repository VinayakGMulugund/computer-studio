import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar'
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { Router, RouterLink } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { RegisterComponent } from '../register/register.component';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { UserService } from '../services/api-service/user.service';
import { Subscription } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [MatToolbarModule, MatIconModule, MatButtonModule, RouterLink, LoginComponent, RegisterComponent, MatDialogModule, CommonModule],
  templateUrl: './navbar.component.html',
  providers: [],
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit, OnDestroy {

  private subscriptions = new Subscription();

  // public userLoggedIn = false;

  @Input() userLoggedIn = false;

  constructor(
    private dialog: MatDialog,
    private userService: UserService,
    private readonly router: Router
  ) {}

  ngOnInit(): void {
    this.userLoggedIn = this.userService.isUserLoggedIn();

    this.userService.userLoginStatusSubject.subscribe(() => {
      this.userLoggedIn = this.userService.isUserLoggedIn();
    })
  }

  openLoginDialog(): void {
    this.dialog.open(LoginComponent, {
      width: '400px'
    }).afterClosed().subscribe(() => {
      this.userLoggedIn = this.userService.isUserLoggedIn();
    });
  }

  openRegisterDialog(): void {
    this.dialog.open(RegisterComponent, {
      width: '400px'
    }).afterClosed().subscribe(value => {
      if (value)
        this.openLoginDialog();
    });
  }

  logout(): void {
    this.userService.logout();
    this.userLoggedIn = false;
    this.router.navigate(['']);
  }

  ngOnDestroy(): void {
    
  }

}
