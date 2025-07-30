package com.cibertec.repaso.Controlador;

import com.cibertec.repaso.DTO.Cursos.CursosDTO;
import com.cibertec.repaso.DTO.Horario.HorarioDTO;
import com.cibertec.repaso.Servicios.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Horario")
@CrossOrigin(origins = "http://localhost:4200")

public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping("/buscarHorarios")
    public ResponseEntity<List<HorarioDTO>> listadoHorarios(){
        return new ResponseEntity<>(horarioService.listaHorarios(), HttpStatus.OK);
    }

    @PostMapping("/{horarioId}/horario/{cursoId}")
    public ResponseEntity<HorarioDTO> agregarCursosHorario(@PathVariable long horarioId, @PathVariable long cursoId) {
        return new ResponseEntity<>(horarioService.AgregarCursoHorario(horarioId, cursoId), HttpStatus.OK);
    }



}
