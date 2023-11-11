import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
	searchTerm: string = '';
	showDropdown: boolean = false;
	users: any[] = [];

	// onChange of searchTerm, fetchSearch
  
	constructor(private router: Router) {}
  
	navigate(path: string) {
		this.router.navigateByUrl(path);
	}
  
	hideDropdown() {
		console.log("hide dropdown");
	}
  
	toggleDarkMode() {
		console.log("dark mode");
	}
  
	handleLogout() {
		console.log("logout");
		localStorage.removeItem('authToken');
		this.router.navigateByUrl('/login');
	}

}
