package com.cibertec.repaso.Controlador;


import com.cibertec.repaso.DTO.Alumno.AlumnoCreateDTO;
import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.DTO.Alumno.AlumnoUpdateDTO;
import com.cibertec.repaso.Servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AlumnoControlador")
@CrossOrigin(origins = "http://localhost:4200")  // Permitir CORS
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/Alumnos")
    public ResponseEntity<List<AlumnoDTO>> listarAlumnos(){
        return new ResponseEntity<>(alumnoService.listarAlumnos() , HttpStatus.OK);
    }

    @PostMapping("/CreateAlumno")
    public ResponseEntity<AlumnoDTO> guardarAlumno(@RequestBody AlumnoCreateDTO alumnoCreateDTO){
        return new ResponseEntity<>(alumnoService.crearAlumno(alumnoCreateDTO), HttpStatus.OK);
    }

    @PostMapping("/{alumnoId}/cursos/{cursoId}")
    public ResponseEntity<AlumnoDTO> agregarCursos(@PathVariable Long alumnoId,@PathVariable Long cursoId ){
        return new ResponseEntity<>(alumnoService.agregarCursos(alumnoId,cursoId), HttpStatus.OK);
    }

    @PutMapping("/actualizarAlumno")
    public ResponseEntity<AlumnoDTO> actualizarAlumno(@RequestBody AlumnoUpdateDTO alumnoUpdateDTO){
        return new ResponseEntity<>(alumnoService.actualizarAlumno(alumnoUpdateDTO), HttpStatus.OK);
    }

    @GetMapping("/buscarAlumno/{alumnoId}")
    public ResponseEntity<AlumnoDTO> buscarAlumnoPorId(@PathVariable int alumnoId){
        return new ResponseEntity<>(alumnoService.buscarId(alumnoId), HttpStatus.OK);
    }

    @DeleteMapping("/eliminarAlumno/{alumnoId}")
    public String eliminarAlumnoPorId(@PathVariable int alumnoId){
        return alumnoService.eliminar(alumnoId);
    }








}
