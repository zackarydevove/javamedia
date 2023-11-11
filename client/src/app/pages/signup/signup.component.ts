import { Component } from '@angular/core';
import { Router } from '@angular/router';
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
  
	constructor(private authService: AuthService, private router: Router) {}
  
	register(): void {
	  const payload: RegisterPayload = {
		email: this.email,
		username: this.username,
		password: this.password,
		confirmPassword: this.confirmPassword
	  };
	  
	  this.authService.register(payload).subscribe({
		next: (response) => {
		  console.log(response);
		  localStorage.setItem('authToken', response.token);
		  this.router.navigateByUrl('/feed');
		},
		error: (error) => {
		  // Handle error
		  console.error(error);
		}
	  });
	}

}
