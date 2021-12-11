package com.informatorio.proyectofinal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Emprendimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String contenido;
    private LocalDate fechaCreacion;
    private Double objetivo;
    private Boolean publicado;
    private String url;
    private String tags;

    public Emprendimiento() {
    }

}
