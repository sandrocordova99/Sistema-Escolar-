package com.cibertec.repaso.DTO.Alumno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoAlumnoRequestDTO {

    private Long alumnoId;
    private Long cursoId;


}
