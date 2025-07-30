package com.cibertec.repaso.Mappers;

import com.cibertec.repaso.DTO.Horario.HorarioDTO;
import com.cibertec.repaso.Entidades.Horario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HorarioMapper {

    HorarioMapper horarioMapper = Mappers.getMapper(HorarioMapper.class);
    
    @Mapping(source = "cursos" , target = "CursosDTO")
    List<HorarioDTO> listarHorario(List<Horario> horarioList);

    HorarioDTO deEntityADTO(Horario horario);

}
