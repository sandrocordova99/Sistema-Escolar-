package com.cibertec.repaso.Servicios;

import com.cibertec.repaso.DTO.Alumno.AlumnoCreateDTO;
import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.DTO.Alumno.AlumnoUpdateDTO;
import com.cibertec.repaso.DTO.Profesor.ProfesorCreateDTO;
import com.cibertec.repaso.DTO.Profesor.ProfesorDTO;
import com.cibertec.repaso.DTO.Profesor.ProfesorUpdateDTO;

import java.util.List;

public interface ProfesorService {

    List<ProfesorDTO> listarProfesor();

    ProfesorDTO crearProfesor(ProfesorCreateDTO profesorCreateDTO);

    ProfesorDTO actualizarProfesor(ProfesorUpdateDTO profesorUpdateDTO);

    ProfesorDTO buscarId(long id);

    String eliminar(long id);


}
