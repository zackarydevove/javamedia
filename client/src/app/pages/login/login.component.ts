import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService, LoginPayload } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
	email: string = '';
	password: string = '';
  
	constructor(private authService: AuthService, private router: Router) {}
  
	login(): void {
	  const payload: LoginPayload = {
		email: this.email,
		password: this.password
	  };
  

	  this.authService.login(payload).subscribe({
		next: (response) => {
		  console.log('Login successful:', response);
		  localStorage.setItem('authToken', response.token);
		  this.router.navigateByUrl('/feed');
		},
		error: (error) => {
		  console.error('Login failed:', error);
		}
	  });
	}

}
