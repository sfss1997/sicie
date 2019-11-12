import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParticipanteItemTableComponent } from './participante-item-table.component';

describe('ParticipanteItemTableComponent', () => {
  let component: ParticipanteItemTableComponent;
  let fixture: ComponentFixture<ParticipanteItemTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParticipanteItemTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParticipanteItemTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
