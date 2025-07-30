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
  selector: 'app-actualizar-alumno',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, FormsModule],
  templateUrl: './actualizar-alumno.component.html',
  styleUrl: './actualizar-alumno.component.css'
})

export class ActualizarAlumnoComponent implements OnInit {
  editarAlumno: Alumnos = {
    id: 0,
    nombre: '',
    paterno: '',
    materno: '',
    nacimiento: new Date(),
    gradoDTO: { id: 1, descripcion: 'Primer Grado' },
    cursosDTO: [],
    salonDTO: { id: 1, descripcion: 'Salon 1' }
  };

  grados: Grados[] = [];
  cursos: Cursos[] = [];
  salones: Salon[] = [];


  gradoSeleccionado: Grados | null = null;
  salonSeleccionado: Salon | null = null;
  cursosSeleccionados: Cursos[] = [];
  mensaje: string = '';

  constructor(
    private router: Router,
    private alumnoService: AlumnosService,
    private gradoService: GradosService,
    private cursoService: CursosService,
    private salonService: SalonesService
  ) { }

  ngOnInit(): void {
    this.cargarDatosIniciales();
    this.obtenerAlumno();
  }

  private cargarDatosIniciales(): void {
    this.cargarGrados();
    this.cargarCursos();
    this.cargarSalones();
  }

  private cargarGrados(): void {
    this.gradoService.getGrados().subscribe(grados => this.grados = grados);
  }

  private cargarCursos(): void {
    this.cursoService.getCursos().subscribe(cursos => this.cursos = cursos);
  }

  private cargarSalones(): void {
    this.salonService.getSalones().subscribe(salones => this.salones = salones);
  }

  private obtenerAlumno(): void {
    const id = JSON.parse(localStorage.getItem('id') || '0');
    this.alumnoService.getAlumnoId(id).subscribe(alumno => {
        if (alumno) {
            this.editarAlumno = alumno;
            this.gradoSeleccionado = alumno.gradoDTO || null;
            this.cursosSeleccionados = alumno.cursosDTO || [];
            this.salonSeleccionado = alumno.salonDTO || null;
        } else {
            this.mensaje = 'Alumno no encontrado';
            console.error(this.mensaje);
        }
    }, error => {
        this.mensaje = 'Error al obtener el alumno';
        console.error(error);
    });
}

  isCursoSeleccionado(curso: Cursos): boolean {
    return this.cursosSeleccionados.some(c => c.id === curso.id);
  }

  seleccionarCurso(curso: Cursos): void {
    const index = this.cursosSeleccionados.findIndex(c => c.id === curso.id);
    if (index === -1) {
      this.cursosSeleccionados.push(curso);
    } else {
      this.cursosSeleccionados.splice(index, 1);
    }
  }


  actualizarAlumno(): void {
    if (!this.gradoSeleccionado) {
        console.error("Grado no seleccionado");
        return; 
    }
    
    this.editarAlumno.gradoDTO = this.gradoSeleccionado;

    this.editarAlumno.cursosDTO = this.cursosSeleccionados; 
    this.editarAlumno.salonDTO = this.salonSeleccionado || this.editarAlumno.salonDTO;

    this.alumnoService.updateAlumno(this.editarAlumno).subscribe(
        () => {
            this.router.navigate(['/listarAlumnos']);
        },
        error => {
            console.error("Error al actualizar alumno", error);
        }
    );
}

  trackByCurso(index: number, curso: Cursos): number {
    return curso.id; 
  }
}
