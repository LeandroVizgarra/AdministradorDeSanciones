package com.example.demo.mapper;

import com.example.demo.dtos.PersonaDTO;
import com.example.demo.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {
    @Autowired
    private SancionMapper sancionMapper;

    public PersonaDTO personaEntity2DTO(Persona persona){
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setId(persona.getId());
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setPuesto(persona.getPuesto());
        personaDTO.setListaSanciones(sancionMapper.sancionEntityList2DTOList(persona.getListaSanciones()));
        return personaDTO;
    }
    public Persona personaDTO2Entity(PersonaDTO dto){
        Persona persona = new Persona();
        persona.setNombre(dto.getNombre());
        persona.setPuesto(dto.getPuesto());
        return persona;
    }
}
