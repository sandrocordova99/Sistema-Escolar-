package com.cibertec.repaso.Controlador;

import com.cibertec.repaso.DTO.Horario.HorarioDTO;
import com.cibertec.repaso.DTO.Salon.SalonDTO;
import com.cibertec.repaso.Servicios.HorarioService;
import com.cibertec.repaso.Servicios.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Salon")
@CrossOrigin(origins = "http://localhost:4200")
public class SalonController {

    @Autowired
    private SalonService salonService;

    @GetMapping("/buscarSalones")
    public ResponseEntity<List<SalonDTO>> listadoHorarios(){
        return new ResponseEntity<>(salonService.listaralones(), HttpStatus.OK);
    }



}
