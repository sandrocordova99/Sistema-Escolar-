package com.cibertec.repaso.Servicios;


import com.cibertec.repaso.DTO.Alumno.AlumnoCreateDTO;
import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.DTO.Alumno.AlumnoUpdateDTO;
import com.cibertec.repaso.Entidades.Alumno;

import java.util.List;

//Logica de negocio
public interface AlumnoService {

    //Implementar mis metodos

    List<AlumnoDTO> listarAlumnos();

    AlumnoDTO crearAlumno(AlumnoCreateDTO alumnoCreateDTO);

    AlumnoDTO actualizarAlumno(AlumnoUpdateDTO alumnoUpdateDTO);

    AlumnoDTO buscarId(int id);

    String eliminar(int id);

    AlumnoDTO agregarCursos(long alumnoId, Long cursoId);


}
