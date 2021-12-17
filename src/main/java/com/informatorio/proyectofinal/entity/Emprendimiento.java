package com.informatorio.proyectofinal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Emprendimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre del emprendimiento no puede ser nulo o vacío")
    private String nombre;
    private String descripcion;
    private String contenido;
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    private BigDecimal objetivo;
    private Boolean publicado;
    private String url;
    @JsonIgnore
    @OneToMany(mappedBy = "emprendimiento",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Voto> votos;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "emprendimiento_tag",
            joinColumns = @JoinColumn(name = "emprendimiento_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();
    @ManyToOne
    private Evento evento;

    public Emprendimiento() {
    }

    public Emprendimiento(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void agregarTag(Tag tag){
        tags.add(tag);
        tag.getEmprendimientos().add(this);
    }

    public void removerTag(Tag tag){
        tags.remove(tag);
        tag.getEmprendimientos().remove(null);
    }
    public void agregarVoto(Voto voto) {
        votos.add(voto);
    }

    public void removeVotes(Voto voto) {
        votos.remove(voto);
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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
