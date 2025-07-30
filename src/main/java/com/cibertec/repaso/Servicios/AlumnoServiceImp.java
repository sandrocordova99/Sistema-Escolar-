package com.cibertec.repaso.Servicios;

import com.cibertec.repaso.DTO.Alumno.AlumnoCreateDTO;
import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.DTO.Alumno.AlumnoUpdateDTO;
import com.cibertec.repaso.DTO.Cursos.CursosDTO;
import com.cibertec.repaso.DTO.Cursos.CursosUpdateDTO;
import com.cibertec.repaso.DTO.Grado.GradoDTO;
import com.cibertec.repaso.DTO.Salon.SalonDTO;
import com.cibertec.repaso.Entidades.Alumno;
import com.cibertec.repaso.Entidades.Cursos;
import com.cibertec.repaso.Entidades.Grado;
import com.cibertec.repaso.Entidades.Salones;
import com.cibertec.repaso.Mappers.AlumnoMapper;
import com.cibertec.repaso.Mappers.CursoMapper;
import com.cibertec.repaso.Mappers.GradoMapper;
import com.cibertec.repaso.Mappers.SalonMapper;
import com.cibertec.repaso.Repositorio.AlumnoRepository;
import com.cibertec.repaso.Repositorio.CursoRepostory;
import com.cibertec.repaso.Repositorio.GradoRepository;
import com.cibertec.repaso.Repositorio.SalonRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mysql.cj.conf.PropertyKey.logger;

@Service
public class AlumnoServiceImp implements AlumnoService{


    private final AlumnoRepository alumnoRepository;
    private final CursoRepostory cursoRepostory;
    private final GradoRepository gradoRepository;
    private final SalonRepository salonRepository;

    @Autowired
    public AlumnoServiceImp (AlumnoRepository alumnoRepository, CursoRepostory cursoRepostory, GradoRepository gradoRepository, SalonRepository salonRepository){
        this.alumnoRepository = alumnoRepository;
        this.cursoRepostory = cursoRepostory;
        this.gradoRepository = gradoRepository;
        this.salonRepository = salonRepository;
    }

    @Transactional
    @Override
    public List<AlumnoDTO> listarAlumnos(){
        List<AlumnoDTO> listado = AlumnoMapper.alumnoMapper.listadoAlumno(alumnoRepository.findAll());
        for(AlumnoDTO alumnoDTO:listado){
            //Encuentras las entidades asociadas a mi Alumno --/-- mediante el id de mi alumno
            List<CursosDTO> cursosDTO = CursoMapper.cursoMapper.listadoCursos(cursoRepostory.findCursoByAlumnosId(alumnoDTO.getId()));
            GradoDTO gradoDTO = GradoMapper.gradoMapper.deEntityADTO(gradoRepository.findGradoByAlumnoId(alumnoDTO.getId()));

            //Tu quieres encontrar los alumnos que estan en un determinado salon
            SalonDTO salonDTO = SalonMapper.mapperSalon.deEntityADTO(salonRepository.findSalonesByAlumnosId(alumnoDTO.getId()));

            alumnoDTO.setCursosDTO(cursosDTO);
            alumnoDTO.setGradoDTO(gradoDTO);
            alumnoDTO.setSalonDTO(salonDTO);
        }
        return listado;
    }

    @Override
    @Transactional
    public AlumnoDTO crearAlumno(AlumnoCreateDTO alumnoCreateDTO) {
        if (alumnoCreateDTO == null) {
            throw new IllegalArgumentException("El DTO del alumno no puede ser nulo.");
        }

        Alumno alumno = AlumnoMapper.alumnoMapper.crearAlumno(alumnoCreateDTO);
        Alumno guardar;

        try {
            guardar = alumnoRepository.save(alumno);

            // Obtener y guardar las entidades relacionadas
            List<Cursos> cursos = cursoRepostory.findCursoByAlumnosId(guardar.getId());
            guardar.setCursos(cursos);
            cursoRepostory.saveAll(cursos);

            Grado grado = gradoRepository.findGradoByAlumnoId(guardar.getId());
            if (grado != null) {
                guardar.setGrado(grado);
                gradoRepository.save(grado);
            }

            Salones salon = salonRepository.findSalonesByAlumnosId(guardar.getId());
            if (salon != null) {
                guardar.setSalon(salon);
                salonRepository.save(salon);
            }

        } catch (DataAccessException e) {
            throw new RuntimeException("Error al guardar el alumno o sus entidades relacionadas", e);
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado durante la creación del alumno", e);
        }

        // Mapeo y retorno del DTO
        AlumnoDTO guardarDTO = AlumnoMapper.alumnoMapper.entityADTO(guardar);

        if (guardar.getCursos() != null) {
            guardarDTO.setCursosDTO(CursoMapper.cursoMapper.listadoCursos(guardar.getCursos()));
        }

        if (guardar.getGrado() != null) {
            GradoDTO gradoDTO = GradoMapper.gradoMapper.deEntityADTO(guardar.getGrado());
            guardarDTO.setGradoDTO(gradoDTO);
        }

        if (guardar.getSalon() != null) {
            SalonDTO salonDTO = SalonMapper.mapperSalon.deEntityADTO(guardar.getSalon());
            guardarDTO.setSalonDTO(salonDTO);
        }

        return guardarDTO;
    }






    @Override
    @Transactional
    public AlumnoDTO agregarCursos(long alumnoId, Long cursoId) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(alumnoId);
        Optional<Cursos> cursosOptional = cursoRepostory.findById(cursoId);

        if (alumnoOptional.isEmpty()) {
            throw new EntityNotFoundException("Alumno no encontrado con ID: " + alumnoId);
        }

        if (cursosOptional.isEmpty()) {
            throw new EntityNotFoundException("Curso no encontrado con ID: " + cursoId);
        }

        Alumno alumno = alumnoOptional.get();
        Cursos curso = cursosOptional.get();

        try {
            alumno.getCursos().add(curso);
            Alumno respuesta = alumnoRepository.save(alumno);
            return AlumnoMapper.alumnoMapper.entityADTO(respuesta);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error al agregar el curso al alumno", e);
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado al agregar el curso", e);
        }
    }

    @Override
    @Transactional
    public AlumnoDTO actualizarAlumno(AlumnoUpdateDTO alumnoUpdateDTO) {
        // Validar la entrada
        if (alumnoUpdateDTO == null) {
            throw new IllegalArgumentException("Objeto inválido");
        }

        // Validar grado
        if (alumnoUpdateDTO.getGradoDTO() == null ||
                alumnoUpdateDTO.getGradoDTO().getId() == null) {
            throw new IllegalArgumentException("Grado no puede ser nulo");
        }

        // Validar cursos
        if (alumnoUpdateDTO.getCursosDTO() == null) {
            throw new IllegalArgumentException("Lista de cursos no puede ser nula");
        }

        // Validar salón
        if (alumnoUpdateDTO.getSalonDTO() == null ||
                alumnoUpdateDTO.getSalonDTO().getId() == null) {
            throw new IllegalArgumentException("Salón no puede ser nulo");
        }

        // Encuentra el alumno existente
        Alumno alumnoActualizado = alumnoRepository.findById(alumnoUpdateDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Alumno no encontrado con ID: " + alumnoUpdateDTO.getId()));

        try {
            // Actualiza los campos básicos del alumno
            alumnoActualizado.setNombre(alumnoUpdateDTO.getNombre());
            alumnoActualizado.setPaterno(alumnoUpdateDTO.getPaterno());
            alumnoActualizado.setMaterno(alumnoUpdateDTO.getMaterno());
            alumnoActualizado.setNacimiento(alumnoUpdateDTO.getNacimiento());

            // Actualiza Grado
            Grado grado = gradoRepository.findById(alumnoUpdateDTO.getGradoDTO().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Grado no encontrado con ID: " + alumnoUpdateDTO.getGradoDTO().getId()));
            alumnoActualizado.setGrado(grado);

            // Actualiza Cursos
            List<Cursos> cursosActualizados = new ArrayList<>();
            for (CursosDTO cursoDTO : alumnoUpdateDTO.getCursosDTO()) {
                Cursos curso = cursoRepostory.findById(cursoDTO.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con ID: " + cursoDTO.getId()));
                cursosActualizados.add(curso);
            }
            alumnoActualizado.setCursos(cursosActualizados);

            // Actualiza Salon
            Salones salon = salonRepository.findById(alumnoUpdateDTO.getSalonDTO().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Salón no encontrado con ID: " + alumnoUpdateDTO.getSalonDTO().getId()));
            alumnoActualizado.setSalon(salon);

            // Guardar y devolver el DTO
            Alumno respuesta = alumnoRepository.save(alumnoActualizado);
            AlumnoDTO respuestaDTO = AlumnoMapper.alumnoMapper.entityADTO(respuesta);

            // Mapeo de Grado
            GradoDTO gradoDTO = GradoMapper.gradoMapper.deEntityADTO(grado);
            respuestaDTO.setGradoDTO(gradoDTO);

            // Mapeo de Cursos
            List<CursosDTO> cursosDTOS = CursoMapper.cursoMapper.listadoCursos(cursosActualizados);
            respuestaDTO.setCursosDTO(cursosDTOS);

            // Mapeo de Salón
            SalonDTO salonDTO = SalonMapper.mapperSalon.deEntityADTO(salon);
            respuestaDTO.setSalonDTO(salonDTO);

            return respuestaDTO;

        } catch (EntityNotFoundException e) {
            throw new RuntimeException("No se encontró el recurso requerido: " + e.getMessage(), e);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error al acceder a los datos durante la actualización del alumno", e);
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado durante la actualización del alumno", e);
        }
    }



    @Override
    public AlumnoDTO buscarId(int id) {

       //el int,float al ser primitivos no permiten igualarlos a nulo
        Optional<Alumno> alumnoOptional = alumnoRepository.findById((long) id);

        try {
            if(!alumnoOptional.isPresent()){
                throw  new EntityNotFoundException("Entidad no encontrada");
            }else{
                Alumno alumno = alumnoOptional.get();
                AlumnoDTO alumnoDTO = AlumnoMapper.alumnoMapper.entityADTO(alumno);
                return alumnoDTO;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String eliminar(int id) {

        Optional<Alumno> alumnoOptional = alumnoRepository.findById((long) id);

        try {
            if(!alumnoOptional.isPresent()){
                throw  new EntityNotFoundException("Entidad no encontrada");
            }else{
                Alumno alumno = alumnoOptional.get();
                alumnoRepository.delete(alumno);
                return "Alumno eliminado exitosamente";
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return "";
    }


}


