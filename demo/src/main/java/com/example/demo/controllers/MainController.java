package com.example.demo.controllers;

import com.example.demo.dtos.PersonaDTO;
import com.example.demo.dtos.SancionDTO;
import com.example.demo.service.PersonaService;
import com.example.demo.service.SancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {
    private final PersonaService personaService;
    private final SancionService sancionService;
    @Autowired
    public MainController(PersonaService personaService, SancionService sancionService) {
        this.personaService = personaService;
        this.sancionService = sancionService;
    }
    @GetMapping("/personas")
    public ResponseEntity<List<PersonaDTO>> obtenerListadoPersonas(){
        List<PersonaDTO> personas = personaService.obtenerListadoDePersonas();
        return new ResponseEntity<>(personas,HttpStatus.OK);
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<PersonaDTO> obtenerPersonaPorId(@PathVariable Long id){
        PersonaDTO personaDTO = personaService.obtenerPersonaDTOPorId(id);
        return new ResponseEntity<>(personaDTO, HttpStatus.OK);
    }
    @PostMapping("persona/crear")
    public ResponseEntity<PersonaDTO> crearPersona(@RequestBody PersonaDTO dto){
        PersonaDTO persona = personaService.crearPersona(dto);
        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }
    @PostMapping("persona/{id}/sancionar")
    public ResponseEntity<PersonaDTO> sancionarPersona(@PathVariable Long id,
                                                       @RequestBody SancionDTO dto){
        SancionDTO sancion = sancionService.crearSancion(dto);
        PersonaDTO personaSancionada = personaService.agregarSancionAPersona(id,sancion.getId());
        return new ResponseEntity<>(personaSancionada,HttpStatus.CREATED);
    }
    @DeleteMapping("/persona/{id}/quitar/{sancionId}")
    public ResponseEntity<PersonaDTO> quitarSancionAPersona(@PathVariable Long id,
                                                            @PathVariable Long sancionId){
        PersonaDTO personaDTO = personaService.quitarSancionAPersona(id,sancionId);
        return new ResponseEntity<>(personaDTO,HttpStatus.OK);
    }
}
