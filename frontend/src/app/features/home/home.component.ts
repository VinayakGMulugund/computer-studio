import { CommonModule } from '@angular/common';
import { Component, EventEmitter, OnInit } from '@angular/core';
import { ComputerComponent } from '../computers/computer/computer.component';
import { Router, RouterModule } from '@angular/router';
import { SidebarComponent } from '../../core/sidebar/sidebar.component';
import { Computer } from '../../models/computer';
import { ProductService } from '../../core/services/api-service/product.service';
import { UserService } from '../../core/services/api-service/user.service';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { LoginComponent } from '../../core/login/login.component';
import { RegisterComponent } from '../../core/register/register.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, ComputerComponent, RouterModule, SidebarComponent, MatDialogModule, LoginComponent, RegisterComponent],
  providers: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  constructor(
    private readonly router: Router,
    private readonly productService: ProductService,
    private readonly userService: UserService,
    private readonly dialog: MatDialog
  ) {}
  public computers: Computer[] = [];

  public loginEmitter = new EventEmitter<boolean>();

ngOnInit(): void {
  this.productService.getAllComputers().subscribe({
    next: (computers) => this.computers = computers,
    error: e => console.log(e)
  });
}

goToStudio() {
    if (!this.userService.isUserLoggedIn()) {
      this.openLoginDialog();
      return;
    }
    this.router.navigate(['/studio']);
  }

  openLoginDialog(): void {
    this.dialog.open(LoginComponent, {
      width: '400px'
    }).afterClosed().subscribe(() => {
      this.userService.userLoginStatusSubject.next(true);
      this.router.navigate(['/studio']);
    });
  }



}
