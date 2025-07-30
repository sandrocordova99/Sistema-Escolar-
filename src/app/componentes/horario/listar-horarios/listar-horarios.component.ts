import { Component, OnInit } from '@angular/core';
import { HorarioService } from '../../../servicios/horario.service';
import { Horario } from '../../../modelo/Horario';
import { error } from 'console';
import { Router, RouterModule, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';  

@Component({
  selector: 'app-listar-horarios',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterModule],
  templateUrl: './listar-horarios.component.html',
  styleUrl: './listar-horarios.component.css'
})


export class ListarHorariosComponent implements OnInit {
  ngOnInit(): void {
    this.obtenerHorario();
  }

  constructor(
    private horarioService:HorarioService,
    private router : Router
  ){}

  Horario? : Horario[];

  obtenerHorario():void {
    this.horarioService.getHorarios().subscribe(
      data => {
        console.log('Datos recibidos',data);
        this.Horario = data;
      },error => {
        console.log('Error al conseguir datos,', error);
      }
    );
  }
}
