import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Profesor}  from '../modelo/Profesor';

@Injectable({
  providedIn: 'root'
})
export class ProfesoresService {

  constructor(private http:HttpClient) {}
  url = 'http://localhost:8080/profesores';

  getProfesores():Observable<Profesor[]>{
    return this.http.get<Profesor[]>(this.url + '/profesores');
  }

  createProfesor(profesor : Profesor):Observable<Profesor>{
    return this.http.post<Profesor>(this.url + '/CreateProfesor',profesor);
  }

  actualizarProfesor(profesor:Profesor):Observable<Profesor>{
    return this.http.put<Profesor>(this.url + '/actualizarProfesor' , profesor);
  }

  buscarProfesor(id: number):Observable<Profesor>{
    return this.http.get<Profesor>(this.url + '/buscarProfesor/' + id);
  }

  eliminarProfesor(id : number):Observable<any>{
    return this.http.delete(this.url + '/eliminarProfesor/' + id);
  }




}
