package com.cibertec.repaso.DTO.Profesor;

import com.cibertec.repaso.DTO.Cursos.CursosDTO;
import com.cibertec.repaso.DTO.Grado.GradoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ProfesorUpdateDTO {
    private Long id;

    private String Nombre;

    private String Paterno;

    private String Materno;

    private Date Nacimiento;

    private List<GradoDTO> gradoDTO;

    private CursosDTO cursosDTO;
}
