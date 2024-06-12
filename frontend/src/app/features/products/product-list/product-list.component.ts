import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink, RouterModule } from '@angular/router';
import { SidebarComponent } from '../../../core/sidebar/sidebar.component';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [RouterLink, CommonModule, RouterModule, SidebarComponent],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

  constructor(private readonly router: Router) {}

  public products = [
    {name: "product-1", category:"cpu", price :"kjsndfkjsd", id:"thisisid"},
    {name: "product-1", category:"cpu", price :"kjsndfkjsd", id:"thisisid"},
    {name: "product-1", category:"cpu", price :"kjsndfkjsd", id:"thisisid"},
    {name: "product-1", category:"cpu", price :"kjsndfkjsd", id:"thisisid"},
    {name: "product-1", category:"cpu", price :"kjsndfkjsd", id:"thisisid"},
    {name: "product-1", category:"cpu", price :"kjsndfkjsd", id:"thisisid"},
  ]

  public goToProduct(id?: string) {
    if (!id)
      return;
    this.router.navigate(['products', id]);
  }

}
