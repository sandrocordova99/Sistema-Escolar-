import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Horario } from '../modelo/Horario';

@Injectable({
  providedIn: 'root'
})
export class HorarioService {

  constructor(private http: HttpClient) { }
  url = 'http://localhost:8080/Horario';

  getHorarios(): Observable<Horario[]> {
    return this.http.get<Horario[]>(this.url + '/buscarHorarios');
  }


  createHorarioCursos(idHorario: number, idCurso: number): Observable<Horario> {
    return this.http.post<Horario>(this.url + idHorario + '/horario/' + idCurso, {});
  }




}
