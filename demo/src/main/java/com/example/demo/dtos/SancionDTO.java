package com.example.demo.dtos;

import com.example.demo.entities.Persona;
import lombok.Data;
@Data
public class SancionDTO {
    private Long id;
    private String descripcion;
    private Long personaId;
}
