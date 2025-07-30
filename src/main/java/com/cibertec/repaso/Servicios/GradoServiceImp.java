package com.cibertec.repaso.Servicios;

import com.cibertec.repaso.DTO.Grado.GradoDTO;
import com.cibertec.repaso.Entidades.Grado;
import com.cibertec.repaso.Mappers.GradoMapper;
import com.cibertec.repaso.Repositorio.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradoServiceImp implements GradoService{

    private final GradoRepository gradoRepository;

    @Autowired
    public GradoServiceImp(GradoRepository gradoRepository) {
        this.gradoRepository = gradoRepository;
    }

    @Override
    public List<GradoDTO> listarGrados() {

        List<Grado> listaGrados = gradoRepository.findAll();
        List<GradoDTO> gradoDTOs = GradoMapper.gradoMapper.listarGrados(listaGrados);
        return gradoDTOs;
    }
}
