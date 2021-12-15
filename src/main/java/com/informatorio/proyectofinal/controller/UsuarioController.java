package com.informatorio.proyectofinal.controller;

import com.informatorio.proyectofinal.entity.Usuario;
import com.informatorio.proyectofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Objects;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioController(UsuarioRepository repository){
        this.repository = repository;
    }

    @GetMapping()
    public ResponseEntity<?> obtenerUsuarios(
            @RequestParam(name = "fechaCreacion",required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaCreacion,
            @RequestParam(name = "ciudad", required = false ) String ciudad) {
        if (fechaCreacion != null) {
            return new ResponseEntity<>(repository.findByFechaCreacionAfter(fechaCreacion.atStartOfDay()),HttpStatus.OK);
        } else if (Objects.nonNull(ciudad))
        {
        return new ResponseEntity<>(repository.findByCiudad(ciudad),HttpStatus.OK);
        }
        return new ResponseEntity(repository.findAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Usuario obtenerUsuarioPorId(@PathVariable("id") Long id){
        return repository.findById(id).get();
    }

    @PostMapping()
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity(repository.save(usuario), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Usuario modificarUsuario(@PathVariable("id") Long id,@RequestBody Usuario usuario){
        Usuario usuarioExistente = repository.findById(id).get();
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido(usuario.getApellido());
        usuarioExistente.setTipo(usuario.getTipo());
        usuarioExistente.setProvincia(usuario.getProvincia());
        usuarioExistente.setPais(usuario.getPais());
        usuarioExistente.setCiudad(usuario.getCiudad());
        return repository.save(usuarioExistente);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable("id") Long id){
        repository.deleteById(id);
    }
}
