import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotifPrestatireComponent } from './notif-prestatire.component';

describe('NotifPrestatireComponent', () => {
  let component: NotifPrestatireComponent;
  let fixture: ComponentFixture<NotifPrestatireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotifPrestatireComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NotifPrestatireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
