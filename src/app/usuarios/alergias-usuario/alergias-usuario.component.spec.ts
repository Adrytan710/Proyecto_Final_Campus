import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlergiasUsuarioComponent } from './alergias-usuario.component';

describe('AlergiasUsuarioComponent', () => {
  let component: AlergiasUsuarioComponent;
  let fixture: ComponentFixture<AlergiasUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlergiasUsuarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlergiasUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
