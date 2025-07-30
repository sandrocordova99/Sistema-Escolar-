package com.cibertec.repaso.Controlador;

import com.cibertec.repaso.DTO.Alumno.AlumnoCreateDTO;
import com.cibertec.repaso.DTO.Alumno.AlumnoDTO;
import com.cibertec.repaso.DTO.Profesor.ProfesorCreateDTO;
import com.cibertec.repaso.DTO.Profesor.ProfesorDTO;
import com.cibertec.repaso.DTO.Profesor.ProfesorUpdateDTO;
import com.cibertec.repaso.Servicios.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfesorController {

    @Autowired
     private ProfesorService profesorService;

    @GetMapping("/profesores")
    public ResponseEntity<List<ProfesorDTO>> listarProfesor(){
        return new ResponseEntity<>(profesorService.listarProfesor() , HttpStatus.OK);
    }

    @PostMapping("/CreateProfesor")
    public ResponseEntity<ProfesorDTO> guardarProfesor(@RequestBody ProfesorCreateDTO profesorCreateDTO){
        return new ResponseEntity<>(profesorService.crearProfesor(profesorCreateDTO), HttpStatus.OK);
    }

    @PutMapping("/actualizarProfesor")
    public ResponseEntity<ProfesorDTO> actualizarProfesor(@RequestBody ProfesorUpdateDTO profesorUpdateDTO){
        return new ResponseEntity<>(profesorService.actualizarProfesor(profesorUpdateDTO), HttpStatus.OK);
    }

    @GetMapping("/buscarProfesor/{id}")
    public ResponseEntity<ProfesorDTO> buscarProfesor(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(profesorService.buscarId(id) , HttpStatus.OK);
    }

    @DeleteMapping("/eliminarProfesor/{id}")
    public ResponseEntity<String> eliminarProfesor(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(profesorService.eliminar(id) , HttpStatus.OK);
    }



}
