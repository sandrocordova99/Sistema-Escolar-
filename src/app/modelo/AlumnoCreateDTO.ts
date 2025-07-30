import { CursosCreateDTO } from "./CursosCreateDTO";
import { GradoCreateDTO } from "./GradoCreateDTO";
import { Salon } from "./Salon";

export interface AlumnosCreateDTO {
    id: number;
    nombre: string;
    paterno: string;
    materno: string;
    nacimiento: Date;
    gradoCreateDTO?: GradoCreateDTO;
    cursosCreateDTO: CursosCreateDTO[];
    salonDTO: Salon;
  }