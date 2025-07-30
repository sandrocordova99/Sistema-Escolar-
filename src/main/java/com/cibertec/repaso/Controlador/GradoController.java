package com.cibertec.repaso.Controlador;

import com.cibertec.repaso.DTO.Grado.GradoDTO;
import com.cibertec.repaso.DTO.Horario.HorarioDTO;
import com.cibertec.repaso.Servicios.GradoService;
import com.cibertec.repaso.Servicios.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Grado")
@CrossOrigin(origins = "http://localhost:4200")
public class GradoController {

    @Autowired
    private GradoService gradoService;

    @GetMapping("/buscarGrados")
    public ResponseEntity<List<GradoDTO>> listadoGrados(){
        return new ResponseEntity<>(gradoService.listarGrados(), HttpStatus.OK);
    }


}
