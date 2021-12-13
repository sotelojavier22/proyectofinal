package com.informatorio.proyectofinal.controller;

import com.informatorio.proyectofinal.entity.Usuario;
import com.informatorio.proyectofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioController(UsuarioRepository repository){
        this.repository = repository;
    }

    @GetMapping()
    public ResponseEntity<?> findUsuarios(){
        return new ResponseEntity(repository.findAll(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> crear(@RequestBody Usuario usuario){
        return new ResponseEntity(repository.save(usuario), HttpStatus.CREATED);
    }
}
