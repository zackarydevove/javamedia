import { Component } from '@angular/core';
import { AuthService, RegisterPayload } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
	email: string = '';
	username: string = '';
	password: string = '';
	confirmPassword: string = '';
  
	constructor(private authService: AuthService) {}
  
	register(): void {
	  const payload: RegisterPayload = {
		email: this.email,
		username: this.username,
		password: this.password,
		confirmPassword: this.confirmPassword
	  };
	  
	  this.authService.register(payload).subscribe({
		next: (response) => {
		  // Handle response
		  console.log(response);
		},
		error: (error) => {
		  // Handle error
		  console.error(error);
		}
	  });
	}

}
