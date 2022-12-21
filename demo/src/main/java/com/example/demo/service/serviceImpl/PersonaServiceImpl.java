package com.example.demo.service.serviceImpl;

import com.example.demo.dtos.PersonaDTO;
import com.example.demo.entities.Persona;
import com.example.demo.entities.Sancion;
import com.example.demo.mapper.PersonaMapper;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;
import com.example.demo.service.SancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;
    private final SancionService sancionService;
    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository, PersonaMapper personaMapper, SancionService sancionService) {
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
        this.sancionService = sancionService;
    }

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



    public void eliminarPersona(Long personaId){
        Persona persona = this.encontrarPersonaPorId(personaId);
        personaRepository.delete(persona);
    }

    public PersonaDTO agregarSancionAPersona(Long personId, Long sancionId){
        Persona persona = this.encontrarPersonaPorId(personId);
        Sancion sancion = sancionService.encontrarSancionPorId(sancionId);
        persona.agregarSancion(sancion);
        Persona personaUpdate = personaRepository.save(persona);
        return personaMapper.personaEntity2DTO(personaUpdate);
    }
    public PersonaDTO obtenerPersonaDTOPorId(Long id){
        return personaMapper.personaEntity2DTO(this.encontrarPersonaPorId(id));
    }

    public PersonaDTO quitarSancionAPersona(Long personId, Long sancionId){
        Persona persona = this.encontrarPersonaPorId(personId);
        persona.quitarSancion(sancionId);
        Persona personaUpdate = personaRepository.save(persona);

        return personaMapper.personaEntity2DTO(personaUpdate);
    }

    public List<PersonaDTO> obtenerListadoDePersonas(){
        List<Persona> personas = personaRepository.findAll();
        return personaMapper.personaEntityList2DTOList(personas);
    }
}
