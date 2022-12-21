package com.example.demo.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PersonaDTO {
    private Long id;
    private String nombre;
    private String puesto;
    private List<SancionDTO> listaSanciones = new ArrayList<>();

}
