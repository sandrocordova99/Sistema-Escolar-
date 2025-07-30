import { Component, OnInit } from '@angular/core';
import { Alumnos } from '../../../modelo/Alumnos';
import { AlumnosService } from '../../../servicios/alumnos.service';
import { CommonModule } from '@angular/common';  
import { Router, RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-listar-alumnos',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterModule],
  templateUrl: './listar-alumnos.component.html',
  styleUrl: './listar-alumnos.component.css'
})
export class ListarAlumnosComponent implements OnInit{
  
  //1.
  Alumnos? : Alumnos[];

  //2.
  constructor(private alumnosService : AlumnosService , private router : Router){}


  ngOnInit(): void {
    this.obtenerAlumnos();
  }

  obtenerAlumnos(): void {
    this.alumnosService.getAlumnos().subscribe(
        data => {
            console.log('Datos recibidos:', data); 
            this.Alumnos = data;
        },
        error => {
            console.log('Error al obtener alumnos:', error);
        }
    );
}



  editarAlumnos(alumnos:Alumnos):void{
      console.log("Editanto alumno: " , alumnos);
      localStorage.setItem("id",alumnos.id.toString());
      this.router.navigate(['/actualizarAlumnos']);
  }

  eliminarAlumno(alumno:Alumnos):void{
      this.alumnosService.deleteAlumno(alumno.id).subscribe(
        data => {
          this.Alumnos = this.Alumnos!.filter(p => p! == alumno);
        },
        error => {
          console.log(error);
        }
      )
  }

  crearAlumno(): void{
      console.log("Creando un nuevo alumno");
      this.router.navigate(['/crearAlumnos']);
  }



}
