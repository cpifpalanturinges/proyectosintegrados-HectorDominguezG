import { Component } from '@angular/core';
import { ForumPost } from '../../models/forumpost';
import { DatePipe, NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-foro',
  imports: [DatePipe, FormsModule, NgIf, NgFor],
  templateUrl: './foro.component.html',
  styleUrl: './foro.component.css'
})
export class ForoComponent {
  forum: ForumPost[] = [];
  newPost: Partial<ForumPost> = {};

  addPost() {
    const post: ForumPost = {
      id: Date.now().toString(),
      username: this.newPost.username!,
      message: this.newPost.message!,
      createdAt: new Date().toISOString()
    };
    this.forum.unshift(post);
    this.newPost = {};
  }
}
