import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuRecintoComponent } from './menu-recinto.component';

describe('MenuRecintoComponent', () => {
  let component: MenuRecintoComponent;
  let fixture: ComponentFixture<MenuRecintoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuRecintoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuRecintoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
