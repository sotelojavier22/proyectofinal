package com.informatorio.proyectofinal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String detallesEvento;
    private LocalDate fechaApertura;
    private LocalDate fechaCierre;
    private String estado;
    private String suscriptores; //emprendiemientos que se registraron
    private Double premio;

    public Evento() {
    }
}
