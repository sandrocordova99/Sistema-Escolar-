import { RouterModule, RouterOutlet, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Profesor } from '../../../modelo/Profesor';
import { GradosService } from '../../../servicios/grados.service';
import { CursosService } from '../../../servicios/cursos.service';
import { Grados } from '../../../modelo/Grado';
import { Cursos } from '../../../modelo/Cursos';
import { ProfesoresService } from '../../../servicios/profesores.service';


@Component({
  selector: 'app-crear-profesores',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule, FormsModule],
  templateUrl: './crear-profesores.component.html',
  styleUrl: './crear-profesores.component.css'
})

export class CrearProfesoresComponent implements OnInit{
  
  ngOnInit(): void {
   this.cargarCursos();
    this.cargarGrados();
  }

  nuevoProf : Profesor = {
    id: 0,
    nombre: '',
    paterno: '',
    materno: '',
    nacimiento: new Date('1990-05-15'),

    gradoDTO: [{id: 1, descripcion: 'Primer Grado' }],
    cursosDTO: {id: 1, descripcion: 'Matematica' }
  }    
  
  constructor(
    private router: Router,
    private gradoService: GradosService,
    private cursoService: CursosService,
    private profesorService : ProfesoresService
  ) { }

  gradoSeleccionado : Grados[] = [];
  cursoSeleccionado : Cursos | null = null;

  cursosList : Cursos[] = [];
  gradoList : Grados[] = [];

  cargarCursos():void {
    this.cursoService.getCursos().subscribe(
      cursosList => { 
        this.cursosList = cursosList 
      },
      error => {
        console.error(error);
      }
    );
  }

  cargarGrados():void {
    this.gradoService.getGrados().subscribe(
      gradoList => {
        this.gradoList = gradoList
      },
      error => {
        console.error(error);
      }
    );
  }

  guardar():void {
    this.nuevoProf.gradoDTO = this.gradoSeleccionado || this.nuevoProf.gradoDTO;
    this.nuevoProf.cursosDTO = this.cursoSeleccionado ||this.nuevoProf.cursosDTO;

    this.profesorService.createProfesor(this.nuevoProf).subscribe(
      () =>{
        this.router.navigate(['/listarProfesores']);
      } ,
      error =>{
        console.error("error al crear al profesor" , error);
      }
    );
  }


  
}
