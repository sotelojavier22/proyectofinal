package com.informatorio.proyectofinal.controller;

import com.informatorio.proyectofinal.entity.Voto;
import com.informatorio.proyectofinal.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/voto")
public class VotoController {

    private VotoRepository repository;

    @Autowired
    public VotoController(VotoRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<?> findVotos(@RequestParam(name = "usuario",required = false) String usuario) {
        if (usuario != null){
            return new ResponseEntity(repository.findByUsuario(usuario),HttpStatus.OK);
        }
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<?> crear(@RequestBody Voto voto){
        return new ResponseEntity<>(repository.save(voto),HttpStatus.CREATED);
    }
}
