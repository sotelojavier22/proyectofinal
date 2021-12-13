package com.informatorio.proyectofinal.controller;

import com.informatorio.proyectofinal.entity.Evento;
import com.informatorio.proyectofinal.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/evento")
public class EventoController {

    private EventoRepository repository;

    @Autowired
    public EventoController(EventoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<?> findEventos(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Evento evento) {
        return new ResponseEntity<>(repository.save(evento),HttpStatus.CREATED);
    }
}
