import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';  
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { Profesor } from '../../../modelo/Profesor';
import { ProfesoresService } from '../../../servicios/profesores.service';

@Component({
  selector: 'app-lista-profesores',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterModule],
  templateUrl: './lista-profesores.component.html',
  styleUrl: './lista-profesores.component.css'
})
export class ListaProfesoresComponent {

//1. 
profesores?:Profesor[];

//2.
constructor(private profesorService : ProfesoresService , private router : Router){}

ngOnInit(): void {
  this.obtenerProfesores();
}

obtenerProfesores():void {
  this.profesorService.getProfesores().subscribe(
    data => {
      console.log('Datos recibidos: ',data);
    
      this.profesores = data;
    },
    error => {
      console.log('Error al obtener profesor',error);
    }
  );
}

editarProfesores(profesor:Profesor):void {
  console.log('Editando profesor: ', profesor);
  localStorage.setItem("id" , profesor.id.toString());
  this.router.navigate(['/actualizarProfesores'])
}

eliminarProfesor(profesor:Profesor):void {
  this.profesorService.eliminarProfesor(profesor.id).subscribe(
    data => {
      this.profesores = this.profesores!.filter(p => p! == profesor);
    },
    error => {
      console.log(error);
    }
  )
}

crearProfesor():void{
  console.log('Creando Profesor');
  this.router.navigate(['/crearProfesores'])
}

}
