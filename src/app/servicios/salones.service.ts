import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Salon } from '../modelo/Salon';

@Injectable({
  providedIn: 'root'
})
export class SalonesService {

  constructor(private http:HttpClient) {}
  url = 'http://localhost:8080/Salon';


  getSalones():Observable<Salon[]>{
    return this.http.get<Salon[]>(this.url + '/buscarSalones');
  }

}
