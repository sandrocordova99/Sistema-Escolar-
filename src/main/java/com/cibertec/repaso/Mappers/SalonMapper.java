package com.cibertec.repaso.Mappers;

import com.cibertec.repaso.DTO.Salon.SalonDTO;
import com.cibertec.repaso.Entidades.Salones;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SalonMapper {

    SalonMapper mapperSalon = Mappers.getMapper(SalonMapper.class);

    List<SalonDTO> listarSalones(List<Salones> salonesList);

    SalonDTO deEntityADTO(Salones salone);
}
