import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-feed-profile-info',
  templateUrl: './feed-profile-info.component.html',
  styleUrls: ['./feed-profile-info.component.scss']
})
export class FeedProfileInfoComponent {

	// currentUser
	// editable boolean

	fakeProfile = {
		username: 'johndoe',
		followersCount: 150,
		location: 'New York, USA',
		job: 'Software Developer'
	}
	constructor(private router: Router) {}
  
	navigateToProfile() {
	  	this.router.navigate(['/profile/', this.fakeProfile.username]);
	}
}
