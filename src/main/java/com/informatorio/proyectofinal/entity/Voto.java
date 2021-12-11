package com.informatorio.proyectofinal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String generadoPor;
    private String usuario;
    private LocalDateTime fechaCreacion;

    public Voto() {
    }
}
