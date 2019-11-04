import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarCoordinacionComponent } from './navbar-coordinacion.component';

describe('NavbarCoordinacionComponent', () => {
  let component: NavbarCoordinacionComponent;
  let fixture: ComponentFixture<NavbarCoordinacionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbarCoordinacionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarCoordinacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
