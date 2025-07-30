package com.cibertec.repaso.Controlador;

import com.cibertec.repaso.DTO.Cursos.CursosDTO;
import com.cibertec.repaso.Servicios.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cursos")
@CrossOrigin(origins = "http://localhost:4200")

public class CursosController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/buscarCursos")
    public ResponseEntity<List<CursosDTO>> listadoCursos(){
        return new ResponseEntity<>(cursoService.listaCursos(), HttpStatus.OK);
    }

    @GetMapping("/buscarCursos/{cursosId}")
    public ResponseEntity<CursosDTO> buscaroCursos(@PathVariable int cursosId){
        return new ResponseEntity<>(cursoService.buscarId(cursosId), HttpStatus.OK);
    }


}
