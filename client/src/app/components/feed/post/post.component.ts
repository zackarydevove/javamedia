import { Component, Input } from '@angular/core';
import { PostInterface } from 'src/app/interfaces/UserInterface';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent {
	@Input() post!: PostInterface;
}
