import { CommonModule } from '@angular/common';  
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { CursosService } from '../../../servicios/cursos.service';
import { Cursos } from '../../../modelo/Cursos';


@Component({
  selector: 'app-buscar-cursos-id',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterModule],
  templateUrl: './buscar-cursos-id.component.html',
  styleUrls: ['./buscar-cursos-id.component.css'] // Corrección aquí
})



export class BuscarCursosIdComponent implements OnInit {

  ngOnInit(): void {
    this.obtenerCursos();
  }


  constructor(
    private cursoService:CursosService,
    private router : Router
  ){}

  Cursos? : Cursos[];

  obtenerCursos(): void{
    this.cursoService.getCursos().subscribe(
      data => {
        console.log('Datos recibidos',data);
        this.Cursos = data ;
      } ,
      error => {
        console.log('Error al obtener cursos', error);
      }
    );
  }
  
  //
}
