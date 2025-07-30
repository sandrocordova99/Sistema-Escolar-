package com.cibertec.repaso.Mappers;

import com.cibertec.repaso.DTO.Grado.GradoDTO;
import com.cibertec.repaso.Entidades.Grado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GradoMapper {

    GradoMapper gradoMapper = Mappers.getMapper(GradoMapper.class);

    GradoDTO deEntityADTO(Grado grado);

    List<GradoDTO> listarGrados(List<Grado> gradoList);











}
