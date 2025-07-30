import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, RouterOutlet, Router } from '@angular/router';
import { Alumnos } from '../../../modelo/Alumnos';
import { AlumnosService } from '../../../servicios/alumnos.service';
import { GradosService } from '../../../servicios/grados.service';
import { CursosService } from '../../../servicios/cursos.service';
import { SalonesService } from '../../../servicios/salones.service';
import { Grados } from '../../../modelo/Grado';
import { Cursos } from '../../../modelo/Cursos';
import { Salon } from '../../../modelo/Salon';


@Component({
  selector: 'app-crear-alumno',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, FormsModule],
  templateUrl: './crear-alumno.component.html',
  styleUrl: './crear-alumno.component.css'
})
export class CrearAlumnoComponent implements OnInit {


  ngOnInit(): void {
    this.cargarCursos();
    this.cargarGrados();
    this.cargarSalones();
  }

  nuevoAlumno: Alumnos = {
    id: 0,
    nombre: '',
    paterno: '',
    materno: '',
    nacimiento: new Date('1990-05-15'),
    gradoDTO: { id: 1, descripcion: 'Primer Grado' },
    cursosDTO: [
      { id: 1, descripcion: 'Matematica' }],
    salonDTO: { id: 1, descripcion: 'Salon 1' }
  };

  constructor(
    private router: Router,
    private alumnoService: AlumnosService,
    private gradoService: GradosService,
    private cursoService: CursosService,
    private salonService: SalonesService
  ) { }

  gradoSeleccionado: Grados | null = null;
  cursoSeleccionado: Cursos[] = [];
  salonSeleccionado: Salon | null = null;

  grados: Grados[] = [];
  cursos: Cursos[] = [];
  salones: Salon[] = [];

  cargarGrados(): void {
    this.gradoService.getGrados().subscribe(
      grados => {
        this.grados = grados;
        console.log('Grados cargados:', this.grados);
      },
      error => {
        console.error('Error al cargar grados', error);
      }
    );
  }

  cargarCursos(): void {
    this.cursoService.getCursos().subscribe(
      cursos => { this.cursos = cursos }
    )
  }

  cargarSalones(): void {
    this.salonService.getSalones().subscribe(
      salones => {
        this.salones = salones;
        console.log(this.salones);
      },
      error => {
        console.error(error);
      }

    )
  }

  /**Como en el Spring , las propiedades anidadas son las que tengo que setear manualmente */
  guardar(): void {
    this.nuevoAlumno.gradoDTO = this.gradoSeleccionado || this.nuevoAlumno.gradoDTO;
    this.nuevoAlumno.cursosDTO = this.cursoSeleccionado || this.nuevoAlumno.cursosDTO;
    this.nuevoAlumno.salonDTO = this.salonSeleccionado || this.nuevoAlumno.salonDTO;

    this.alumnoService.createAlumno(this.nuevoAlumno).subscribe(
      () => {
        this.router.navigate(['/listarAlumnos']);
        console.log('Grado seleccionado:', this.gradoSeleccionado);
        console.log('Cursos seleccionados:', this.cursoSeleccionado);
        console.log('Salon seleccionado:', this.salonSeleccionado);
      },
      error => {
        console.error('Error al crear alumno', error);
      }
    );

  }

}
