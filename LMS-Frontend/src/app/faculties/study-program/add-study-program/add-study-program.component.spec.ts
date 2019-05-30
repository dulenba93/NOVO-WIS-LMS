import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStudyProgramComponent } from './add-study-program.component';

describe('AddStudyProgramComponent', () => {
  let component: AddStudyProgramComponent;
  let fixture: ComponentFixture<AddStudyProgramComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddStudyProgramComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddStudyProgramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
