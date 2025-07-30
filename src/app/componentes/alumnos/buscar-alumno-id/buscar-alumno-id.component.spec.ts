import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarAlumnoIdComponent } from './buscar-alumno-id.component';

describe('BuscarAlumnoIdComponent', () => {
  let component: BuscarAlumnoIdComponent;
  let fixture: ComponentFixture<BuscarAlumnoIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuscarAlumnoIdComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BuscarAlumnoIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
