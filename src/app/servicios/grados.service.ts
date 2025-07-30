import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Grados } from '../modelo/Grado';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GradosService {

  constructor(private http:HttpClient) {}
  url = 'http://localhost:8080/Grado';

  getGrados():Observable<Grados[]>{
    return this.http.get<Grados[]>(this.url + '/buscarGrados');
  }
}
