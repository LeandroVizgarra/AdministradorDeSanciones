package com.example.demo.service;

import com.example.demo.dtos.PersonaDTO;
import com.example.demo.entities.Persona;

public interface PersonaService {
    Persona encontrarPersonaPorId(Long id);
    PersonaDTO obtenerPersonaDTOPorId(Long id);
    PersonaDTO crearPersona(PersonaDTO dto);
    void eliminarPersona(Long personaId);
    PersonaDTO agregarSancionAPersona(Long personId, Long sancionId);
    PersonaDTO quitarSancionAPersona(Long personId, Long sancionId);

}
