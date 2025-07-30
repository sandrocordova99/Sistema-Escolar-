import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarCursosIdComponent } from './buscar-cursos-id.component';

describe('BuscarCursosIdComponent', () => {
  let component: BuscarCursosIdComponent;
  let fixture: ComponentFixture<BuscarCursosIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuscarCursosIdComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BuscarCursosIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
