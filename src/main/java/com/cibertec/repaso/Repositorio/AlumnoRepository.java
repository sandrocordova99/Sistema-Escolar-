package com.cibertec.repaso.Repositorio;

import com.cibertec.repaso.Entidades.Alumno;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
    List<Alumno> findAlumnosByCursosId (long id);
}
