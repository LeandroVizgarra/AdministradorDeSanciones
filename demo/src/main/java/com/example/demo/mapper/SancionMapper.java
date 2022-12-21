package com.example.demo.mapper;

import com.example.demo.dtos.SancionDTO;
import com.example.demo.entities.Sancion;
import com.example.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SancionMapper {
    private final PersonaService personaService;

    public SancionMapper(PersonaService personaService) {
        this.personaService = personaService;
    }

    public SancionDTO sancionEntity2DTO(Sancion sancion){

        SancionDTO sancionDTO = new SancionDTO();
        sancionDTO.setDescripcion(sancion.getDescripcion());
        sancionDTO.setPersonaId(sancionDTO.getPersonaId());
        sancionDTO.setId(sancion.getId());

        return sancionDTO;
    }

    public Sancion sancionDTO2Entity(SancionDTO dto){
        Sancion sancion = new Sancion();
        sancion.setDescripcion(dto.getDescripcion());
        sancion.setPersona(personaService.encontrarPersonaPorId(dto.getPersonaId()));
        return sancion;
    }

    public List<SancionDTO> sancionEntityList2DTOList(List<Sancion> sanciones){
        List<SancionDTO> sancionesDTOS = new ArrayList<>();

        for(Sancion sancion : sanciones){
            sancionesDTOS.add(this.sancionEntity2DTO(sancion));
        }
        return sancionesDTOS;
    }
}
