package com.informatorio.proyectofinal.controller;

import com.informatorio.proyectofinal.entity.Evento;
import com.informatorio.proyectofinal.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

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

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Evento modificarEvento(@PathVariable("id") Long id, @RequestBody Evento evento){
        Evento eventoExistente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento no econtrado"));
        eventoExistente.setDetallesEvento(evento.getDetallesEvento());
        eventoExistente.setFechaApertura(evento.getFechaApertura());
        eventoExistente.setFechaCierre(evento.getFechaCierre());
        eventoExistente.setEstado(evento.getEstado());
        eventoExistente.setPremio(evento.getPremio());
        return repository.save(eventoExistente);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void eliminarEvento(@PathVariable("id") Long id){
        repository.deleteById(id);
    }
}
