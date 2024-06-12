import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../../../models/user';
import { BehaviorSubject, Observable, Subject, Subscription, catchError, map, of, pipe } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private readonly http: HttpClient) {}


  private readonly baseUrl = 'http://localhost:8080/api/user';

  public userLoginStatusSubject = new Subject<boolean>();

  public isUserLoggedIn(): boolean {
    const token = sessionStorage.getItem('token');
    const userLoggedIn = token ? true : false;
    // this.userLoginStatusSubject.next(userLoggedIn);
    return userLoggedIn;
  }

  public login(user: User): Observable<boolean> {
    return this.http.post<{token: string}>(`${this.baseUrl}` + '/login', user).pipe(
      map(response => {
        if (response && response.token) {
          sessionStorage.setItem('token', response.token);
          this.userLoginStatusSubject.next(true);
          return true;
        }
        return false;
      }),
      catchError((error) => {
        console.error('Login error', error);
        return of(false);
      })
    );
  }

  public logout(): void {
    const token = sessionStorage.getItem('token');
    if (token)
      sessionStorage.removeItem('token');
  }

  public register(user: User): Observable<any> {
    if (!user || !user.email || !user.password)
      return of(false);
    if (!user.role) {
      user.role = "ROLE_USER"
    }
    if (!user.username) {
      user.username = user.email.split('@')[0];
    }
    return this.http.post(this.baseUrl + '/register', user);
  }
}
