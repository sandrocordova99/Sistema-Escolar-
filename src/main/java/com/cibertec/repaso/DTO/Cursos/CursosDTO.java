package com.cibertec.repaso.DTO.Cursos;

import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.DTO.Horario.HorarioDTO;
import com.cibertec.repaso.Entidades.Alumno;
import com.cibertec.repaso.Entidades.Horario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CursosDTO {

    private Long id;

    private String descripcion;

/*
    private List<HorarioDTO> horariosDTO;
*/


    /*  private List<AlumnoDTO> alumnosDTO;*/

}
