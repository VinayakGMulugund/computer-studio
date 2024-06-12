import { Injectable } from '@angular/core';

import { Computer } from '../../../models/computer';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/computer';

  constructor(private readonly http: HttpClient) {
    console.log('init');
  }

  public getAllComputers(): Observable<Computer[]> {
    console.log('getAllCom..')
    return this.http.get<Computer[]>(this.baseUrl);
  }
}
