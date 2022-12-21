package com.example.demo.service.serviceImpl;

import com.example.demo.dtos.PersonaDTO;
import com.example.demo.entities.Persona;
import com.example.demo.mapper.PersonaMapper;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PersonaMapper personaMapper;

    public Persona encontrarPersonaPorId(Long id){
        return personaRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No hay nadie registrado con el id: " + id)
        );
    }

    public PersonaDTO crearPersona(PersonaDTO dto){
        Persona persona = personaMapper.personaDTO2Entity(dto);
        Persona personaSave = personaRepository.save(persona);
        return personaMapper.personaEntity2DTO(personaSave);
    }

    public PersonaDTO editarPersona(PersonaDTO dto){
        Persona persona = personaMapper.personaDTO2Entity(dto);
        Persona personaSave = personaRepository.save(persona);
        return personaMapper.personaEntity2DTO(personaSave);
    }

    public void eliminarPersona(Long personaId){
        Persona persona = this.encontrarPersonaPorId(personaId);
        personaRepository.delete(persona);
    }
}
