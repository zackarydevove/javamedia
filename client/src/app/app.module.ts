import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { FeedPageComponent } from './pages/feed-page/feed-page.component';
import { NavbarComponent } from './components/general/navbar/navbar.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FeedProfileInfoComponent } from './components/feed/feed-profile-info/feed-profile-info.component';
import { SendPostComponent } from './components/feed/send-post/send-post.component';
import { RandomAddComponent } from './components/feed/random-add/random-add.component';
import { PostComponent } from './components/feed/post/post.component';
import { FeedComponent } from './components/feed/feed/feed.component';
import { UserBarComponent } from './components/feed/user-bar/user-bar.component';
import { OptionsDropdownComponent } from './components/general/options-dropdown/options-dropdown.component';
import { CommentComponent } from './components/post/comment/comment.component';
import { CommentSectionComponent } from './components/post/comment-section/comment-section.component';
import { CommentPopUpComponent } from './components/post/see-more-comments/comment-pop-up/comment-pop-up.component';
import { CommentSectionPopUpComponent } from './components/post/see-more-comments/comment-section-pop-up/comment-section-pop-up.component';
import { SeeMoreCommentsComponent } from './components/post/see-more-comments/see-more-comments/see-more-comments.component';
import { ProfileFeedComponent } from './components/profile/profile-feed/profile-feed.component';
import { ProfileInfoComponent } from './components/profile/profile-info/profile-info.component';
import { SearchDropdownComponent } from './components/search/search-dropdown/search-dropdown.component';
import { UserSearchComponentComponent } from './components/search/user-search-component/user-search-component.component';
import { ProfilePageComponent } from './pages/profile/profile-page/profile-page.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    FeedPageComponent,
    NavbarComponent,
    FeedProfileInfoComponent,
    SendPostComponent,
    RandomAddComponent,
    PostComponent,
    FeedComponent,
    UserBarComponent,
    OptionsDropdownComponent,
    CommentComponent,
    CommentSectionComponent,
    CommentPopUpComponent,
    CommentSectionPopUpComponent,
    SeeMoreCommentsComponent,
    ProfileFeedComponent,
    ProfileInfoComponent,
    SearchDropdownComponent,
    UserSearchComponentComponent,
    ProfilePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
	HttpClientModule,
	FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
