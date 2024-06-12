import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { UserService } from '../services/api-service/user.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [MatFormFieldModule, MatCardModule, FormsModule, MatDialogModule],
  providers: [UserService],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  public email = "email";
  public password = "pass";
  public confirmPassword = "conpas";

  constructor(public dialogRef: MatDialogRef<RegisterComponent>,
    private readonly userService: UserService
  ) {}

  register(): void {
    const user: User = {email: this.email, password: this.password};
    this.userService.register(user).subscribe({
      next: () => this.dialogRef.close(true),
      error: e => console.log('please try again')
    })
  }
}
