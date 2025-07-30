package com.cibertec.repaso.DTO.Alumno;

import com.cibertec.repaso.DTO.Cursos.CursosDTO;
import com.cibertec.repaso.DTO.Grado.GradoDTO;
import com.cibertec.repaso.DTO.Salon.SalonDTO;
import com.cibertec.repaso.Entidades.Cursos;
import com.cibertec.repaso.Entidades.Grado;
import com.cibertec.repaso.Entidades.Salones;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
/*
@NoArgsConstructor
*/
public class AlumnoDTO {

    private Long id;

    private String Nombre;

    private String Paterno;

    private String Materno;

    private Date Nacimiento;

    //Muchos alumnos pueden pertenecer a un solo grado
    private GradoDTO gradoDTO;

    private List<CursosDTO> cursosDTO;

    private SalonDTO salonDTO;


}
