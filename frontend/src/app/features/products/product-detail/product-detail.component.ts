import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-product-detail',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.css'
})
export class ProductDetailComponent {


  public product = {name: "RTX 3090",
  category: "gpu",
  price: 2999,
  image: "../../../../assets/mae-black-IM0lyt4Uxew-unsplash.jpg",
  description: "loremkasndksjndfkjsndfkjsndfkjnsdkfjnskdjfnksjdfnkjsdnfkjsndfkjnsdkfjnsdkfjnskdjfnskdjfnksdjfksjdfnksjdf"};

  addToCart(product: any) {
    
  }
}
