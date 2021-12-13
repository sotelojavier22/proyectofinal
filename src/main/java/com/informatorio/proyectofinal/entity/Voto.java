package com.informatorio.proyectofinal.entity;

import org.hibernate.annotations.CreationTimestamp;

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
    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    public Voto() {
    }

    public Voto(String generadoPor, String usuario) {
        this.generadoPor = generadoPor;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public String getGeneradoPor() {
        return generadoPor;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setGeneradoPor(String generadoPor) {
        this.generadoPor = generadoPor;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", generadoPor='" + generadoPor + '\'' +
                ", usuario='" + usuario + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
