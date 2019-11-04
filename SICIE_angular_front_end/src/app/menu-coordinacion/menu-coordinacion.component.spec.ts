import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuCoordinacionComponent } from './menu-coordinacion.component';

describe('MenuCoordinacionComponent', () => {
  let component: MenuCoordinacionComponent;
  let fixture: ComponentFixture<MenuCoordinacionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuCoordinacionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuCoordinacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
