package com.cibertec.repaso.Servicios;


import com.cibertec.repaso.DTO.Horario.HorarioDTO;

import java.util.List;

public interface HorarioService {

    List<HorarioDTO> listaHorarios();

    HorarioDTO buscarHorario(long id);

    HorarioDTO AgregarCursoHorario (long horarioId,long cursoId);
}
