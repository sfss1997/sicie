import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordinacionDocentesRegistrarComponent } from './coordinacion-docentes-registrar.component';

describe('CoordinacionDocentesRegistrarComponent', () => {
  let component: CoordinacionDocentesRegistrarComponent;
  let fixture: ComponentFixture<CoordinacionDocentesRegistrarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordinacionDocentesRegistrarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordinacionDocentesRegistrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
