package com.informatorio.proyectofinal.entity;

import com.informatorio.proyectofinal.util.ValidationHelper;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede ser blanco o nulo")
    private String nombre;
    @NotBlank(message = "El apellido no puede ser blanco o nulo")
    private String apellido;
    @NotBlank(message = "El email no puede ser blanco o nulo")
    @Column(unique = true)
    @Email(regexp = ValidationHelper.EMAIL_REGEX)
    private String email;
    @NotBlank(message = "El password no puede ser blanco o nulo")
    private String password;
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    @NotBlank(message = "La ciudad no puede ser blanco o nulo")
    private String ciudad;
    @NotBlank(message = "La provincia no puede ser blanco o nulo")
    private String provincia;
    @NotBlank(message = "El país no puede ser blanco o nulo")
    private String pais;
    @NotBlank(message = "El tipo no puede ser blanco o nulo")
    private String tipo;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String email, String password, String ciudad, String provincia, String pais, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }


    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getPais() {
        return pais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
