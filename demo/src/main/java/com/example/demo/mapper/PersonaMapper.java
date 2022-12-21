package com.example.demo.mapper;

import com.example.demo.dtos.PersonaDTO;
import com.example.demo.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonaMapper {
    private final SancionMapper sancionMapper;
    @Lazy
    @Autowired

    public PersonaMapper(SancionMapper sancionMapper) {
        this.sancionMapper = sancionMapper;
    }

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
    public List<PersonaDTO> personaEntityList2DTOList(List<Persona> personas){

        List<PersonaDTO> personaDTOS = new ArrayList<>();

        for(Persona persona : personas){
            personaDTOS.add(this.personaEntity2DTO(persona));
        }
        return personaDTOS;
    }

}
