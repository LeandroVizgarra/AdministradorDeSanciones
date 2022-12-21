package com.example.demo.service.serviceImpl;

import com.example.demo.dtos.SancionDTO;
import com.example.demo.entities.Persona;
import com.example.demo.entities.Sancion;
import com.example.demo.mapper.SancionMapper;
import com.example.demo.repository.SancionRepository;
import com.example.demo.service.PersonaService;
import com.example.demo.service.SancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SancionesServiceImpl implements SancionService {
    private final SancionRepository sancionRepository;
    private final SancionMapper sancionMapper;
    private final PersonaService personaService;
    @Autowired
    public SancionesServiceImpl(SancionRepository sancionRepository, SancionMapper sancionMapper, PersonaService personaService) {
        this.sancionRepository = sancionRepository;
        this.sancionMapper = sancionMapper;
        this.personaService = personaService;
    }

    public SancionDTO crearSancion(SancionDTO dto){
        Sancion sancion = sancionMapper.sancionDTO2Entity(dto);
        Sancion sancionSave = sancionRepository.save(sancion);
        return sancionMapper.sancionEntity2DTO(sancionSave);
    }
    public List<SancionDTO> obtenerSancionesDePersona(Long idPersona){
        Persona persona = personaService.encontrarPersonaPorId(idPersona);
        return sancionMapper.sancionEntityList2DTOList(persona.getListaSanciones());
    }
    public Sancion encontrarSancionPorId(Long sancionId){
        return sancionRepository.findById(sancionId).orElseThrow(
                ()-> new RuntimeException("No encontrado")
        );
    }

    public void eliminarSancion(Long sancionId){
        sancionRepository.delete(this.encontrarSancionPorId(sancionId));
    }
}
