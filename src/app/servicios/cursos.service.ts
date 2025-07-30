import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cursos } from '../modelo/Cursos';

@Injectable({
  providedIn: 'root'
})
export class CursosService {

  constructor(private http:HttpClient) {}
  url = 'http://localhost:8080/Cursos';

  getCursos():Observable<Cursos[]>{
      return this.http.get<Cursos[]>(this.url + '/buscarCursos');
  }

  getCursosId(id : number): Observable<Cursos>{
    return this.http.get<Cursos>(this.url + '/buscarCursos' + id);
  }

}
