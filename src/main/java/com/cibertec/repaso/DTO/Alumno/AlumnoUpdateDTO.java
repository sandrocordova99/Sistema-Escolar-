package com.cibertec.repaso.DTO.Alumno;

import com.cibertec.repaso.DTO.Cursos.CursosDTO;
import com.cibertec.repaso.DTO.Cursos.CursosUpdateDTO;
import com.cibertec.repaso.DTO.Grado.GradoDTO;
import com.cibertec.repaso.DTO.Grado.GradoUpdateDTO;
import com.cibertec.repaso.DTO.Salon.SalonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoUpdateDTO {
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
