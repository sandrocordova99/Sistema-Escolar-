package com.cibertec.repaso.Repositorio;

import com.cibertec.repaso.Entidades.Salones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<Salones,Long> {

    public Salones findSalonesByAlumnosId(Long Id);

}
