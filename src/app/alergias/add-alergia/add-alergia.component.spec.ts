import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAlergiaComponent } from './add-alergia.component';

describe('AddAlergiaComponent', () => {
  let component: AddAlergiaComponent;
  let fixture: ComponentFixture<AddAlergiaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddAlergiaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAlergiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
