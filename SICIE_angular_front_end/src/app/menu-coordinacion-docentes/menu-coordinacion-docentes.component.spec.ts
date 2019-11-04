import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuCoordinacionDocentesComponent } from './menu-coordinacion-docentes.component';

describe('MenuCoordinacionDocentesComponent', () => {
  let component: MenuCoordinacionDocentesComponent;
  let fixture: ComponentFixture<MenuCoordinacionDocentesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuCoordinacionDocentesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuCoordinacionDocentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
