package com.cibertec.repaso.DTO.Grado;

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
public class GradoUpdateDTO {

    private Long id;

    //private List<AlumnoUpdateDTO> alumnoUpdateDTO;

    private String descripcion;
}
