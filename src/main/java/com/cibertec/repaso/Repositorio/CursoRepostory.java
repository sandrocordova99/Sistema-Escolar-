package com.cibertec.repaso.Repositorio;

import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.Entidades.Alumno;
import com.cibertec.repaso.Entidades.Cursos;
import com.cibertec.repaso.Entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepostory extends JpaRepository<Cursos,Long> {
    //metodo que me permita encontrar un curso, por el Id del alumno

    List<Cursos> findCursoByAlumnosId(Long id);

    Cursos findCursosByProfesoresId(Long id);

    List<Cursos> findCursosByHorariosId(Long id);
}
