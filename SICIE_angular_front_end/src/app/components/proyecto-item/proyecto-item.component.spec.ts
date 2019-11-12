import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProyectoItemComponent } from './proyecto-item.component';

describe('ProyectoItemComponent', () => {
  let component: ProyectoItemComponent;
  let fixture: ComponentFixture<ProyectoItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProyectoItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProyectoItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
