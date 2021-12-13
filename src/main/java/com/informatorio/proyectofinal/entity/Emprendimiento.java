package com.informatorio.proyectofinal.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Emprendimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String contenido;
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    private BigDecimal objetivo;
    private Boolean publicado;
    private String url;
    private String tags;

    public Emprendimiento() {
    }

    public Emprendimiento(String nombre, String descripcion, String contenido, BigDecimal objetivo, Boolean publicado, String url, String tags) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.objetivo = objetivo;
        this.publicado = publicado;
        this.url = url;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public BigDecimal getObjetivo() {
        return objetivo;
    }

    public Boolean getPublicado() {
        return publicado;
    }

    public String getUrl() {
        return url;
    }

    public String getTags() {
        return tags;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setObjetivo(BigDecimal objetivo) {
        this.objetivo = objetivo;
    }

    public void setPublicado(Boolean publicado) {
        this.publicado = publicado;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Emprendimiento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", objetivo=" + objetivo +
                ", publicado=" + publicado +
                ", url='" + url + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
