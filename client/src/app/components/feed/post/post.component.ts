import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { PostInterface } from 'src/app/interfaces/UserInterface';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent {
	@Input() post!: PostInterface;

	// currentUser
	// seeMoreComments boolean
	// showDropdown boolean
	// User liked post boolean

	// onInit fetchCheckIfUserLikedPost
	// handleDeletePost
	// handleLike

	constructor(private router: Router) {}
  
	navigateToProfile(username: string) {
	  	this.router.navigate(['/profile/', username]);
	}
}
