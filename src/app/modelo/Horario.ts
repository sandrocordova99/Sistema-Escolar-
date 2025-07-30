import { Cursos } from "./Cursos";

export interface Horario{
    /*private Long id;

    private String descripcion;

    private List<CursosDTO> CursosDTO;*/
    
    id : number;
    descripcion : string;
    CursosDTO : Cursos[];


}