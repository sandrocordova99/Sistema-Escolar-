import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarCursosHorarioComponent } from './agregar-cursos-horario.component';

describe('AgregarCursosHorarioComponent', () => {
  let component: AgregarCursosHorarioComponent;
  let fixture: ComponentFixture<AgregarCursosHorarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AgregarCursosHorarioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AgregarCursosHorarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
