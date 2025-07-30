import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Alumnos } from '../modelo/Alumnos';
import { Observable } from 'rxjs';
import { AlumnosCreateDTO } from '../modelo/AlumnoCreateDTO';

@Injectable({
  providedIn: 'root'
})
export class AlumnosService {

  constructor(private http:HttpClient) {}
  url = 'http://localhost:8080/AlumnoControlador';

  getAlumnos():Observable<Alumnos[]>{
    return this.http.get<Alumnos[]>(this.url + '/Alumnos');
  }

  createAlumno(alumno: Alumnos): Observable<Alumnos> {
    return this.http.post<Alumnos>(this.url + '/CreateAlumno', alumno);
  }

  createAlumnoCurso(id: number, alumnoId: number): Observable<Alumnos> {
    return this.http.post<Alumnos>(this.url + alumnoId + '/cursos/' + id , {});
  }

  getAlumnoId(id : number): Observable<Alumnos>{
    return this.http.get<Alumnos>(this.url + '/buscarAlumno/' + id);
  }

  updateAlumno(alumno:Alumnos):Observable<Alumnos>{
    return this.http.put<Alumnos>(this.url + '/actualizarAlumno' ,alumno );
  }

  deleteAlumno(id:number):Observable<any>{
    return this.http.delete(this.url + '/eliminarAlumno/' + id);
  }




}
