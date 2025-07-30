import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarProfesoresComponent } from './actualizar-profesores.component';

describe('ActualizarProfesoresComponent', () => {
  let component: ActualizarProfesoresComponent;
  let fixture: ComponentFixture<ActualizarProfesoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActualizarProfesoresComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActualizarProfesoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
