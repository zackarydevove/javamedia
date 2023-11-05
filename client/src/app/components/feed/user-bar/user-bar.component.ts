import { Component, Input } from '@angular/core';
import { UserInterface } from 'src/app/interfaces/UserInterface';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-bar',
  templateUrl: './user-bar.component.html',
  styleUrls: ['./user-bar.component.scss']
})
export class UserBarComponent {
	@Input() user!: UserInterface;

	// currentUser
	// isFollowing
	isFollowing: boolean = true;
	
	// onInit fetchCheckIfUserIsFollowing

	constructor(private router: Router) {}
  
	navigateToProfile(username: string) {
	  	this.router.navigate(['/profile/', username]);
	}
}
