package com.cibertec.repaso.Mappers;


import com.cibertec.repaso.DTO.Alumno.AlumnoCreateDTO;
import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.DTO.Alumno.AlumnoUpdateDTO;
import com.cibertec.repaso.Entidades.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlumnoMapper {

    //creo una instacia de mapper para acceder a sus metodos
    AlumnoMapper alumnoMapper = Mappers.getMapper(AlumnoMapper.class);

    //creo mis conversiones
    @Mapping(source = "grado" , target = "gradoDTO")
    @Mapping(source = "cursos" , target = "cursosDTO")
    @Mapping(source = "salon" , target = "salonDTO")
    AlumnoDTO entityADTO (Alumno alumno);

    Alumno DTOAAlumno(AlumnoDTO alumnoDTO);

    @Mapping(source = "gradoDTO" , target = "grado")
    @Mapping(source = "cursosDTO" , target = "cursos")
    @Mapping(source = "salonDTO" , target = "salon")
    List<AlumnoDTO> listadoAlumno (List<Alumno> lista);

    @Mapping(source = "gradoDTO" , target = "grado")
    @Mapping(source = "cursosDTO" , target = "cursos")
    @Mapping(source = "salonDTO" , target = "salon")
    Alumno crearAlumno (AlumnoCreateDTO alumnoCreat);

    @Mapping(source = "gradoDTO" , target = "grado")
    @Mapping(source = "cursosDTO" , target = "cursos")
    @Mapping(source = "salonDTO" , target = "salon")
    Alumno actualizarAlumno (AlumnoUpdateDTO alumnoUpdate);

}


