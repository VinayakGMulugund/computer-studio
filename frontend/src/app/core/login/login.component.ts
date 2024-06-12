import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCommonModule } from '@angular/material/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card'
import { MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { UserService } from '../services/api-service/user.service';
import { User } from '../../models/user';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, MatCommonModule, MatFormFieldModule, MatCardModule, MatDialogModule],
  providers: [UserService],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnDestroy {

  public email = "emai";
  public password = "pass";

  private subscriptions = new Subscription();

  constructor(
    public dialogRef: MatDialogRef<LoginComponent>,
    private readonly userService: UserService
  ) {}

  login() {
    const user: User = {email: this.email, password: this.password};
    this.subscriptions.add(this.userService.login(user).subscribe(res => {
      if(res) {
        this.userService.userLoginStatusSubject.next(true);
        this.dialogRef.close();
      } else {
        console.log('invalid username or password');
      } 
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

}
