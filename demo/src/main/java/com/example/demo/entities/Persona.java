package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String puesto;
    @OneToMany(cascade ={
            CascadeType.PERSIST,
            CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinTable(
            name="sanciones",
            joinColumns =@JoinColumn(name="id_sancion"),
            inverseJoinColumns = @JoinColumn(name="id_person")
    )
    private List<Sancion> listaSanciones = new ArrayList<>();

    public void agregarSancion(Sancion sancion){
        this.listaSanciones.add(sancion);
    }

    public void quitarSancion(Long sancionId){
        this.listaSanciones.stream().filter(
                        itemMap -> Objects.equals(itemMap.getId(), sancionId))
                        .findFirst()
                        .ifPresent(item -> this.listaSanciones.remove(item));
    }
}
