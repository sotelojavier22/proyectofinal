package com.informatorio.proyectofinal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
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
    private BigDecimal premio;

    public Evento() {
    }

    public Evento(String detallesEvento, LocalDate fechaApertura, LocalDate fechaCierre, String estado, String suscriptores, BigDecimal premio) {
        this.detallesEvento = detallesEvento;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.suscriptores = suscriptores;
        this.premio = premio;
    }

    public Long getId() {
        return id;
    }

    public String getDetallesEvento() {
        return detallesEvento;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public String getEstado() {
        return estado;
    }

    public String getSuscriptores() {
        return suscriptores;
    }

    public BigDecimal getPremio() {
        return premio;
    }

    public void setDetallesEvento(String detallesEvento) {
        this.detallesEvento = detallesEvento;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setSuscriptores(String suscriptores) {
        this.suscriptores = suscriptores;
    }

    public void setPremio(BigDecimal premio) {
        this.premio = premio;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", detallesEvento='" + detallesEvento + '\'' +
                ", fechaApertura=" + fechaApertura +
                ", fechaCierre=" + fechaCierre +
                ", estado='" + estado + '\'' +
                ", suscriptores='" + suscriptores + '\'' +
                ", premio=" + premio +
                '}';
    }
}
