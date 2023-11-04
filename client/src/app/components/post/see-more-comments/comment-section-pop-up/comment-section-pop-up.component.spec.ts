import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentSectionPopUpComponent } from './comment-section-pop-up.component';

describe('CommentSectionPopUpComponent', () => {
  let component: CommentSectionPopUpComponent;
  let fixture: ComponentFixture<CommentSectionPopUpComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CommentSectionPopUpComponent]
    });
    fixture = TestBed.createComponent(CommentSectionPopUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
