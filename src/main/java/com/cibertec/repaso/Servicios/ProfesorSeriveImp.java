package com.cibertec.repaso.Servicios;

import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.DTO.Cursos.CursosDTO;
import com.cibertec.repaso.DTO.Grado.GradoDTO;
import com.cibertec.repaso.DTO.Profesor.ProfesorCreateDTO;
import com.cibertec.repaso.DTO.Profesor.ProfesorDTO;
import com.cibertec.repaso.DTO.Profesor.ProfesorUpdateDTO;
import com.cibertec.repaso.Entidades.Alumno;
import com.cibertec.repaso.Entidades.Cursos;
import com.cibertec.repaso.Entidades.Grado;
import com.cibertec.repaso.Entidades.Profesor;
import com.cibertec.repaso.Mappers.CursoMapper;
import com.cibertec.repaso.Mappers.GradoMapper;
import com.cibertec.repaso.Mappers.ProfesorMapper;
import com.cibertec.repaso.Repositorio.AlumnoRepository;
import com.cibertec.repaso.Repositorio.CursoRepostory;
import com.cibertec.repaso.Repositorio.GradoRepository;
import com.cibertec.repaso.Repositorio.ProfesorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorSeriveImp implements ProfesorService {

    private final CursoRepostory cursoRepostory;
    private final GradoRepository gradoRepository;
    private final ProfesorRepository profesorRepository;
    private final AlumnoRepository alumnoRepository;

    @Autowired
    public ProfesorSeriveImp(CursoRepostory cursoRepostory, GradoRepository gradoRepository, ProfesorRepository profesorRepository, AlumnoRepository alumnoRepository) {
        this.cursoRepostory = cursoRepostory;
        this.gradoRepository = gradoRepository;
        this.profesorRepository = profesorRepository;
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public List<ProfesorDTO> listarProfesor() {

        List<Profesor> listaProfesores = profesorRepository.findAll();
        List<ProfesorDTO> listaProfesoresDTO = ProfesorMapper.profesorMapper.listarProfesores(listaProfesores);

        for (ProfesorDTO p : listaProfesoresDTO) {
            List<GradoDTO> gradoDTOS = GradoMapper.gradoMapper.listarGrados(gradoRepository.findGradosByProfesoresId(p.getId()));
            CursosDTO cursoDTO = CursoMapper.cursoMapper.deDTOAEntity(cursoRepostory.findCursosByProfesoresId(p.getId()));

            p.setCursosDTO(cursoDTO);
            p.setGradoDTO(gradoDTOS);
        }

        return listaProfesoresDTO;
    }

    @Override
    public ProfesorDTO crearProfesor(ProfesorCreateDTO profesorCreateDTO) {
        // Validar la entrada
        if (profesorCreateDTO == null) {
            throw new IllegalArgumentException("El DTO del profesor no puede ser nulo.");
        }

        // Mapeo y creación del profesor
        Profesor profesor = ProfesorMapper.profesorMapper.crearProfesor(profesorCreateDTO);

        try {
            // Guardar el nuevo profesor en la base de datos
            Profesor profesorSave = profesorRepository.save(profesor);

            // Obtener y guardar los cursos relacionados
            Cursos curso = cursoRepostory.findCursosByProfesoresId(profesorSave.getId());
            if (curso != null) {
                cursoRepostory.save(curso);
                profesorSave.setCursos(curso);
            }

            // Obtener y guardar los grados relacionados
            List<Grado> grados = gradoRepository.findGradosByProfesoresId(profesorSave.getId());
            if (!grados.isEmpty()) {
                gradoRepository.saveAll(grados);
                profesorSave.setGrados(grados);
            }

            // Mapeo y retorno del DTO
            ProfesorDTO profesorDTO = ProfesorMapper.profesorMapper.deEntityADTO(profesorSave);

            // Mapeo de cursos y grados
            if (curso != null) {
                CursosDTO cursosDTO = CursoMapper.cursoMapper.deDTOAEntity(curso);
                profesorDTO.setCursosDTO(cursosDTO);
            }

            List<GradoDTO> gradoDTO = GradoMapper.gradoMapper.listarGrados(grados);
            profesorDTO.setGradoDTO(gradoDTO);

            return profesorDTO;

        } catch (DataAccessException e) {
            throw new RuntimeException("Error al guardar el profesor o sus entidades relacionadas", e);
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado durante la creación del profesor", e);
        }
    }

    @Override
    public ProfesorDTO actualizarProfesor(ProfesorUpdateDTO profesorUpdateDTO) {
        // Validar la entrada
        if (profesorUpdateDTO == null) {
            throw new IllegalArgumentException("Objeto inválido");
        }

        // Buscar el profesor existente
        Profesor profesorEncontradoId = profesorRepository.findById(profesorUpdateDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada, ID inexistente: " + profesorUpdateDTO.getId()));

        try {
            // Actualizar los campos básicos del profesor
            profesorEncontradoId.setNombre(profesorUpdateDTO.getNombre());
            profesorEncontradoId.setPaterno(profesorUpdateDTO.getPaterno());
            profesorEncontradoId.setMaterno(profesorUpdateDTO.getMaterno());
            profesorEncontradoId.setNacimiento(profesorUpdateDTO.getNacimiento());

            // Actualizar Grados
            List<Grado> listaGrados = new ArrayList<>();
            for (GradoDTO g : profesorUpdateDTO.getGradoDTO()) {
                Grado grado = gradoRepository.findById(g.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Grado no encontrado con ID: " + g.getId()));
                listaGrados.add(grado);
            }
            profesorEncontradoId.setGrados(listaGrados);

            // Actualizar Cursos
            Cursos curso = cursoRepostory.findById(profesorUpdateDTO.getCursosDTO().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con ID: " + profesorUpdateDTO.getCursosDTO().getId()));
            profesorEncontradoId.setCursos(curso);

            // Guardar los cambios en la base de datos
            profesorRepository.save(profesorEncontradoId);

            // Mapeo y retorno del DTO
            ProfesorDTO respuestaDTO = ProfesorMapper.profesorMapper.deEntityADTO(profesorEncontradoId);

            List<GradoDTO> gradoDTO = GradoMapper.gradoMapper.listarGrados(listaGrados);
            respuestaDTO.setGradoDTO(gradoDTO);

            CursosDTO cursosDTO = CursoMapper.cursoMapper.deDTOAEntity(curso);
            respuestaDTO.setCursosDTO(cursosDTO);

            return respuestaDTO;

        } catch (DataAccessException e) {
            throw new RuntimeException("Error al actualizar el profesor", e);
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado durante la actualización del profesor", e);
        }
    }


    @Override
    public ProfesorDTO buscarId(long id) {
        // Buscar el profesor por ID
        Optional<Profesor> profesorOptional = profesorRepository.findById(id);

        // Manejo de errores
        if (profesorOptional.isEmpty()) {
            throw new EntityNotFoundException("Profesor no encontrado con ID: " + id);
        }

        // Mapeo y retorno del DTO
        Profesor profesor = profesorOptional.get();
        return ProfesorMapper.profesorMapper.deEntityADTO(profesor);
    }

    @Override
    public String eliminar(long id) {
        // Buscar el profesor por ID
        Optional<Profesor> profesorOptional = profesorRepository.findById(id);

        // Manejo de errores
        if (profesorOptional.isEmpty()) {
            throw new EntityNotFoundException("Profesor no encontrado con ID: " + id);
        }

        // Eliminar el profesor
        profesorRepository.delete(profesorOptional.get());
        return "Profesor eliminado exitosamente";
    }

}