package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Sancion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descripcion;

    @OneToOne
    private Person person;

}
