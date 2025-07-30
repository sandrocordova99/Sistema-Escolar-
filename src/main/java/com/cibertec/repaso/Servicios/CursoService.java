package com.cibertec.repaso.Servicios;

import com.cibertec.repaso.DTO.Cursos.CursosCreateDTO;
import com.cibertec.repaso.DTO.Cursos.CursosDTO;
import com.cibertec.repaso.DTO.Cursos.CursosUpdateDTO;
import com.cibertec.repaso.Entidades.Cursos;

import java.util.List;

public interface CursoService {

    List<CursosDTO> listaCursos();


    CursosDTO buscarId(long id);

    CursosDTO crearCursos(CursosCreateDTO cursosCreateDTO);

    CursosDTO actualizarCursos(CursosUpdateDTO cursosUpdateDTO);

    String eliminarCurso(int id);



}
