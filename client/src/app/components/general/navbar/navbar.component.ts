import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { faSearch, faBars, faMoon, faCommentAlt, faBell, faArrowUpRightFromSquare } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
	searchTerm: string = '';
	showDropdown: boolean = false;
	faSearch = faSearch;
	faBars = faBars;
	faMoon = faMoon;
	faCommentAlt = faCommentAlt;
	faBell = faBell;
	faArrowUpRightFromSquare = faArrowUpRightFromSquare;
	users: any[] = [];
  
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
	}

}
