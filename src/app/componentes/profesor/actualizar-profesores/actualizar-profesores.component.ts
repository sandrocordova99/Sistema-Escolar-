import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, RouterOutlet, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Profesor } from '../../../modelo/Profesor';
import { Cursos } from '../../../modelo/Cursos';
import { Grados } from '../../../modelo/Grado';
import { CursosService } from '../../../servicios/cursos.service';
import { GradosService } from '../../../servicios/grados.service';
import { ProfesoresService } from '../../../servicios/profesores.service';

@Component({
  selector: 'app-actualizar-profesores',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, FormsModule],
  templateUrl: './actualizar-profesores.component.html',
  styleUrl: './actualizar-profesores.component.css'
})
export class ActualizarProfesoresComponent {

  //OnInit
  ngOnInit(): void {
    this.cargarDatosIniciales();
    this.obtenerProfesor();
  }

  editarProfesor: Profesor = {
    id: 0,
    nombre: '',
    paterno: '',
    materno: '',
    nacimiento: new Date(),
    gradoDTO: [],
    cursosDTO: { id: 1, descripcion: 'Matematica' }
  };

  cursosList: Cursos[] = [];
  gradoList: Grados[] = [];

  gradoSeleccionado: Grados[] = [];
  cursoSeleccionado: Cursos | null = null;
  mensaje: string = '';

  constructor(
    private router: Router,
    private gradoService: GradosService,
    private cursoService: CursosService,
    private profesorService: ProfesoresService
  ) { }

  private cargarDatosIniciales(): void {
    this.cargarGrados();
    this.cargarCursos();
  }

  private cargarGrados(): void {
    this.gradoService.getGrados().subscribe(grados => this.gradoList = grados);
  }

  private cargarCursos(): void {
    this.cursoService.getCursos().subscribe(cursos => this.cursosList = cursos);
  }


  private obtenerProfesor(): void {
    const id = JSON.parse(localStorage.getItem('id') || '0');
    this.profesorService.buscarProfesor(id).subscribe(
      alumno => {
        if (alumno) {
          this.editarProfesor = alumno;
          this.gradoSeleccionado = alumno.gradoDTO || [];
          this.cursoSeleccionado = alumno.cursosDTO || null;
        } else {
          this.mensaje = 'Profesor no encontrado';
          console.error(this.mensaje);
        }
      },
      error => {
        this.mensaje = 'Error al obtener el profesor';
        console.error(error);
      }
    );
  }

  isGradoSeleccionado(grado: Grados): boolean {
    return this.gradoSeleccionado.some(g => g.id == grado.id);
  }

  seleccionarGrado(grado: Grados): void {
    const index = this.gradoSeleccionado.findIndex(g => g.id == grado.id);
    if (index === -1) {
      this.gradoSeleccionado.push(grado);
    } else {
      this.gradoSeleccionado.splice(index, 1);
    }
  }


  actualizarProfesor(): void {
    this.editarProfesor.cursosDTO  = this.cursoSeleccionado || this.editarProfesor.cursosDTO;
    this.editarProfesor.gradoDTO = this.gradoSeleccionado ||this.editarProfesor.gradoDTO;
    this.profesorService.actualizarProfesor(this.editarProfesor).subscribe(
      () => {
        this.router.navigate(['/listarProfesores']);
      },
      error => {
        console.error('Error al actualizar profesor: ' , error);
      }
    );
  
  
    
  
  }


  trackByGrado(index: number , grado:Grados) : number {
      return grado.id;
  }


}







