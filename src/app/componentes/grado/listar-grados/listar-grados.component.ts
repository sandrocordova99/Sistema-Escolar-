import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';  
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { GradosService } from '../../../servicios/grados.service';
import { Grados } from '../../../modelo/Grado';

@Component({
  selector: 'app-listar-grados',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterModule],
  templateUrl: './listar-grados.component.html',
  styleUrl: './listar-grados.component.css'
})
export class ListarGradosComponent implements OnInit{
  ngOnInit(): void {
    this.obtenerGrado();
  }

  constructor(
    private gradoService:GradosService,
    private router : Router
  ){}

  Grado? : Grados[];


  obtenerGrado():void {
    this.gradoService.getGrados().subscribe(
      data => {
        console.log('Datos recibidos',data);
        this.Grado = data;
      },
      error => {
        console.log('Error al recibir',error);
      }
    );
  }


}
