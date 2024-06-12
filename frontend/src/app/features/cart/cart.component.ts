import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CartService } from '../../core/services/api-service/cart.service';
import { Computer } from '../../models/computer';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule, RouterModule],
  providers: [CartService],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent implements OnInit {

  public total: number = 0;
  public computers: Computer[] = [];

  constructor(private readonly cartService: CartService) {}

  ngOnInit(): void {
    this.cartService.getCart().subscribe({
      next: (computers) => this.computers = computers
    })
  }

}
