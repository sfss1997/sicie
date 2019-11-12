import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocenteItemTableComponent } from './docente-item-table.component';

describe('DocenteItemTableComponent', () => {
  let component: DocenteItemTableComponent;
  let fixture: ComponentFixture<DocenteItemTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocenteItemTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocenteItemTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
