package com.cibertec.repaso.Servicios;

import com.cibertec.repaso.DTO.Salon.SalonDTO;
import com.cibertec.repaso.Entidades.Salones;
import com.cibertec.repaso.Mappers.SalonMapper;
import com.cibertec.repaso.Repositorio.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonServiceImp implements SalonService{

   private final SalonRepository salonRepository;

   @Autowired
    public SalonServiceImp(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }

    @Override
    public List<SalonDTO> listaralones() {

       List<Salones> listaSalones = salonRepository.findAll();
       List<SalonDTO> listaSalonesDTO = SalonMapper.mapperSalon.listarSalones(listaSalones);

       return listaSalonesDTO;
    }
}
