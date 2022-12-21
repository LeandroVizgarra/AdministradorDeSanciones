package com.example.demo.service;

import com.example.demo.dtos.PersonaDTO;
import com.example.demo.entities.Persona;

public interface PersonaService {
    Persona encontrarPersonaPorId(Long id);
    PersonaDTO crearPersona(PersonaDTO dto);
    PersonaDTO editarPersona(PersonaDTO dto);
    void eliminarPersona(Long personaId);
}
