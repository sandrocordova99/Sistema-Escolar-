package com.cibertec.repaso.Repositorio;

import com.cibertec.repaso.Entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Long> {
}
