import { Cursos } from "./Cursos";
import { Grados } from "./Grado";
import { Salon } from "./Salon";

export interface Alumnos {
    id: number;
    nombre: string;
    paterno: string;
    materno: string;
    nacimiento: Date;
    gradoDTO?: Grados;
    cursosDTO: Cursos[];
    salonDTO: Salon;
  }