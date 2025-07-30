package com.cibertec.repaso.DTO.Horario;

import com.cibertec.repaso.DTO.Cursos.CursosDTO;
import com.cibertec.repaso.Entidades.Cursos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HorarioDTO {

    private Long id;

    private String descripcion;

    private List<CursosDTO> CursosDTO;

}
