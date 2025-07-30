package com.cibertec.repaso.Servicios;

import com.cibertec.repaso.DTO.Cursos.CursosDTO;
import com.cibertec.repaso.DTO.Horario.HorarioDTO;
import com.cibertec.repaso.Entidades.Cursos;
import com.cibertec.repaso.Entidades.Horario;
import com.cibertec.repaso.Mappers.CursoMapper;
import com.cibertec.repaso.Mappers.HorarioMapper;
import com.cibertec.repaso.Repositorio.CursoRepostory;
import com.cibertec.repaso.Repositorio.HorarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImp implements HorarioService {

    private final HorarioRepository horarioRepository;
    private final CursoRepostory cursoRepostory;

    @Autowired
    public HorarioServiceImp(HorarioRepository horarioRepository, CursoRepostory cursoRepostory) {
        this.horarioRepository = horarioRepository;
        this.cursoRepostory = cursoRepostory;
    }

    @Override
    public List<HorarioDTO> listaHorarios() {

        List<Horario> listaHorario = horarioRepository.findAll();
        List<HorarioDTO> listaHorarioDTO = HorarioMapper.horarioMapper.listarHorario(listaHorario);
         for(HorarioDTO h : listaHorarioDTO){
                List<Cursos> listCursos = cursoRepostory.findCursosByHorariosId(h.getId());
                List<CursosDTO> listCursosDTO = CursoMapper.cursoMapper.listadoCursos(listCursos);
                h.setCursosDTO(listCursosDTO);
         }

        return listaHorarioDTO;
    }

    @Override
    public HorarioDTO buscarHorario(long id) {
        return null;
    }


    @Override
    @Transactional
    public HorarioDTO AgregarCursoHorario(long horarioId, long cursoId) {
        Optional<Cursos> cursoOptional = cursoRepostory.findById(cursoId);
        Optional<Horario> horarioOptional = horarioRepository.findById(horarioId);

        if (cursoOptional.isPresent() && horarioOptional.isPresent()) {
            Horario horario = horarioOptional.get();
            Cursos curso = cursoOptional.get();

            horario.getCursos().add(curso);
            curso.getHorarios().add(horario);

            horarioRepository.save(horario);
            return HorarioMapper.horarioMapper.deEntityADTO(horario);
        } else {
            throw new EntityNotFoundException("Horario o curso no encontrado");
        }
    }



}
