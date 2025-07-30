/**  private Long id;

    private String Nombre;

    private String Paterno;

    private String Materno;

    private Date Nacimiento;

    private List<GradoDTO> gradoDTO;

    private CursosDTO cursosDTO; */

import { Cursos } from "./Cursos";
import { Grados } from "./Grado";

    export interface Profesor{
        id: number;
        nombre: string;
        paterno: string;
        materno: string;
        nacimiento: Date;

        
        gradoDTO?: Grados[];
        cursosDTO: Cursos;
        
    }