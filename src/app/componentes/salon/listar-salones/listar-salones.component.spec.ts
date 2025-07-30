import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarSalonesComponent } from './listar-salones.component';

describe('ListarSalonesComponent', () => {
  let component: ListarSalonesComponent;
  let fixture: ComponentFixture<ListarSalonesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarSalonesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarSalonesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
