import { Component, Input } from '@angular/core';
import { CommentInterface } from 'src/app/interfaces/UserInterface';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.scss']
})
export class CommentComponent {
	@Input() comment!: CommentInterface;
}
