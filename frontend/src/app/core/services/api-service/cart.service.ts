import { Injectable } from '@angular/core';
import { Computer } from '../../../models/computer';
import { Observable, Subject } from 'rxjs';
import { Cart } from '../../../models/cart';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private readonly baseUrl = 'http://localhost:8080/api/computer';

  constructor(private readonly http: HttpClient) { }

  public getCart(): Observable<Computer[]> {
    return this.http.get<Computer[]>(this.baseUrl);
  }
  
}
