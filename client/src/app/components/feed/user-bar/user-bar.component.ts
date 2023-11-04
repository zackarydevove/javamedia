import { Component, Input } from '@angular/core';
import { UserInterface } from 'src/app/interfaces/UserInterface';

@Component({
  selector: 'app-user-bar',
  templateUrl: './user-bar.component.html',
  styleUrls: ['./user-bar.component.scss']
})
export class UserBarComponent {
	@Input() user!: UserInterface;

	isFollowing: boolean = true;
}
