import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DarkModeService } from 'src/app/services/darkmode/dark-mode.service';

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
  
	constructor(
		private router: Router,
		protected darkModeService: DarkModeService
	) {}
  
	navigate(path: string) {
		this.router.navigateByUrl(path);
	}
  
	hideDropdown() {
		console.log("hide dropdown");
	}
  
	toggleDarkMode() {
		this.darkModeService.toggleDarkMode();
	}
  
	handleLogout() {
		localStorage.removeItem('authToken');
		this.router.navigateByUrl('/login');
	}

}
