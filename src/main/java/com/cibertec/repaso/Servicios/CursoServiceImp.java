package com.cibertec.repaso.Servicios;

import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.DTO.Cursos.CursosCreateDTO;
import com.cibertec.repaso.DTO.Cursos.CursosDTO;
import com.cibertec.repaso.DTO.Cursos.CursosUpdateDTO;
import com.cibertec.repaso.Entidades.Alumno;
import com.cibertec.repaso.Entidades.Cursos;
import com.cibertec.repaso.Mappers.AlumnoMapper;
import com.cibertec.repaso.Mappers.CursoMapper;
import com.cibertec.repaso.Repositorio.AlumnoRepository;
import com.cibertec.repaso.Repositorio.CursoRepostory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImp implements  CursoService{

    private final CursoRepostory cursoRepostory;
    private final AlumnoRepository alumnoRepository;

    @Autowired
    public CursoServiceImp(CursoRepostory cursoRepostory, AlumnoRepository alumnoRepository){
        this.cursoRepostory = cursoRepostory;
        this.alumnoRepository = alumnoRepository;
    }


    @Override
    public List<CursosDTO> listaCursos() {


        List<CursosDTO> listaCursos = CursoMapper.cursoMapper.listadoCursos(cursoRepostory.findAll());

       for(CursosDTO cursoDTO:listaCursos){
           List<Alumno> listaAlumnos = new ArrayList<>();
           listaAlumnos =  alumnoRepository.findAlumnosByCursosId(cursoDTO.getId());

           List<AlumnoDTO> listaAlumnosDTO = new ArrayList<>();
           listaAlumnosDTO = AlumnoMapper.alumnoMapper.listadoAlumno(listaAlumnos);

           //cursoDTO.setAlumnosDTO(listaAlumnosDTO);
       }
        return listaCursos;
    }

    @Override
    public CursosDTO buscarId(long id) {
        // Buscar el curso por ID
        Optional<Cursos> cursosOptional = cursoRepostory.findById(id);

        // Manejo de errores
        if (cursosOptional.isEmpty()) {
            throw new EntityNotFoundException("Curso no encontrado con ID: " + id);
        }

        // Mapeo y retorno del DTO
        Cursos curso = cursosOptional.get();
        return CursoMapper.cursoMapper.deDTOAEntity(curso);
    }


    @Override
    public CursosDTO crearCursos(CursosCreateDTO cursosCreateDTO) {
        return null;
    }

    @Override
    public CursosDTO actualizarCursos(CursosUpdateDTO cursosUpdateDTO) {
        return null;
    }

    @Override
    public String eliminarCurso(int id) {
        return "";
    }
}
