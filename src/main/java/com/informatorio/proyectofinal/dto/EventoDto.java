package com.informatorio.proyectofinal.dto;

public class EventoDto {
    private Long Id;
    private String detalle;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
