package com.cibertec.repaso.Mappers;

import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.DTO.Cursos.CursosCreateDTO;
import com.cibertec.repaso.DTO.Cursos.CursosDTO;
import com.cibertec.repaso.DTO.Cursos.CursosUpdateDTO;
import com.cibertec.repaso.Entidades.Alumno;
import com.cibertec.repaso.Entidades.Cursos;
import com.cibertec.repaso.Entidades.Grado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CursoMapper {

    CursoMapper cursoMapper = Mappers.getMapper(CursoMapper.class);

    List<CursosDTO> listadoCursos(List<Cursos> listado);

    /*@Mapping(source = "alumnos" , target = "alumnosDTO",qualifiedByName = "mapAlumnosGrado")*/
    CursosDTO deDTOAEntity(Cursos cursos);


    Cursos crearCursos(CursosCreateDTO cursosCreateDTO);

    Cursos actualizarCursos(CursosUpdateDTO cursosUpdateDTO);

   /* @Named("mapAlumnosGrado")
    default AlumnoDTO mapAlumnosGrado(Alumno alumno){
        AlumnoDTO alumnoDTO = new AlumnoDTO();

        alumnoDTO.setId(alumno.getId());
        alumnoDTO.setNombre(alumno.getNombre());
        alumnoDTO.setPaterno(alumno.getPaterno());
        alumnoDTO.setMaterno(alumno.getMaterno());
        alumnoDTO.setNacimiento(alumno.getNacimiento());

        alumnoDTO.setGradoDTO(GradoMapper.gradoMapper.deEntityADTO(alumno.getGrado()));
        return alumnoDTO;
    }*/


}
