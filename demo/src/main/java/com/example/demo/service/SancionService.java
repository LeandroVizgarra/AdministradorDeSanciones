package com.example.demo.service;

import com.example.demo.dtos.SancionDTO;
import com.example.demo.entities.Sancion;

import java.util.List;

public interface SancionService {
    SancionDTO crearSancion(SancionDTO dto);
    List<SancionDTO> obtenerSancionesDePersona(Long idPersona);
    Sancion encontrarSancionPorId(Long sancionId);
    void eliminarSancion(Long sancionId);
}
