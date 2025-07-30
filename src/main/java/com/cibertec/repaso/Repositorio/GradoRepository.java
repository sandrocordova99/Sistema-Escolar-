package com.cibertec.repaso.Repositorio;

import com.cibertec.repaso.Entidades.Grado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradoRepository extends JpaRepository<Grado,Long> {

    //Grados por el id Alumno
    Grado findGradoByAlumnoId(long Id);


    List<Grado> findGradosByProfesoresId(Long id);


}
