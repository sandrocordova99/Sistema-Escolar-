package com.cibertec.repaso.DTO.Grado;

import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.Entidades.Alumno;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class GradoDTO {

    private Long id;

    private String descripcion;

    //private List<AlumnoDTO> alumnoDTO;


}
