import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProyectoFormComponent } from './proyecto-form.component';

describe('ProyectoFormComponent', () => {
  let component: ProyectoFormComponent;
  let fixture: ComponentFixture<ProyectoFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProyectoFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProyectoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
