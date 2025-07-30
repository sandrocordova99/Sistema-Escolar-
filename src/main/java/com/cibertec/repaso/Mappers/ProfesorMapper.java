package com.cibertec.repaso.Mappers;

import com.cibertec.repaso.DTO.Profesor.ProfesorCreateDTO;
import com.cibertec.repaso.DTO.Profesor.ProfesorDTO;
import com.cibertec.repaso.DTO.Profesor.ProfesorUpdateDTO;
import com.cibertec.repaso.Entidades.Profesor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfesorMapper {

    ProfesorMapper profesorMapper = Mappers.getMapper(ProfesorMapper.class);

    @Mapping(source = "grados" , target = "gradoDTO")
    @Mapping(source = "cursos" , target = "cursosDTO")
    ProfesorDTO deEntityADTO(Profesor profesor);

    @Mapping(source = "gradoDTO" , target = "grados")
    @Mapping(source = "cursosDTO" , target = "cursos")
    Profesor deDTOAEntity(ProfesorDTO profesorDTO);

    @Mapping(source = "grados" , target = "gradoDTO")
    @Mapping(source = "cursos" , target = "cursosDTO")
    List<ProfesorDTO> listarProfesores(List<Profesor> profesorList);

    @Mapping(source = "gradoDTO" , target = "grados")
    @Mapping(source = "cursosDTO" , target = "cursos")
    Profesor crearProfesor(ProfesorCreateDTO profesorCreateDTO);

    @Mapping(source = "gradoDTO" , target = "grados")
    @Mapping(source = "cursosDTO" , target = "cursos")
    Profesor actualizarProfesor(ProfesorUpdateDTO profesorUpdateDTO);






}
