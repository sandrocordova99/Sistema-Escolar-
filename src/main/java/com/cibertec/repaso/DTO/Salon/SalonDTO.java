package com.cibertec.repaso.DTO.Salon;

import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.Entidades.Alumno;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SalonDTO {

    private Long id;

    private String descripcion;

/*
    private List<AlumnoDTO> alumnoDTO;
*/
}
