package com.cibertec.repaso.DTO.Cursos;

import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.DTO.Alumno.AlumnoUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursosUpdateDTO {


    private Long id;

    private String descripcion;

    //private List<AlumnoUpdateDTO> alumnosUpdateDTO;
}
