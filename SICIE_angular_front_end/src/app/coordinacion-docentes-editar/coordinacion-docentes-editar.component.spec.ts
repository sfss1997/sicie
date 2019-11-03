import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordinacionDocentesEditarComponent } from './coordinacion-docentes-editar.component';

describe('CoordinacionDocentesEditarComponent', () => {
  let component: CoordinacionDocentesEditarComponent;
  let fixture: ComponentFixture<CoordinacionDocentesEditarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoordinacionDocentesEditarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordinacionDocentesEditarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
