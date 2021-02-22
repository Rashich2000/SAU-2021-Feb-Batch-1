import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuListComponent } from './au-list.component';

describe('AuListComponent', () => {
  let component: AuListComponent;
  let fixture: ComponentFixture<AuListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
