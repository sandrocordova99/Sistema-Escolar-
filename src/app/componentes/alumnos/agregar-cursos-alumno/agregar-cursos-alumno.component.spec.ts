import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarCursosAlumnoComponent } from './agregar-cursos-alumno.component';

describe('AgregarCursosAlumnoComponent', () => {
  let component: AgregarCursosAlumnoComponent;
  let fixture: ComponentFixture<AgregarCursosAlumnoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AgregarCursosAlumnoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AgregarCursosAlumnoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
