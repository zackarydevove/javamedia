import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSearchComponentComponent } from './user-search-component.component';

describe('UserSearchComponentComponent', () => {
  let component: UserSearchComponentComponent;
  let fixture: ComponentFixture<UserSearchComponentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserSearchComponentComponent]
    });
    fixture = TestBed.createComponent(UserSearchComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
