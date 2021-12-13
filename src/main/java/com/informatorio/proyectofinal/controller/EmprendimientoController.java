package com.informatorio.proyectofinal.controller;

import com.informatorio.proyectofinal.entity.Emprendimiento;
import com.informatorio.proyectofinal.repository.EmprendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/emprendimiento")
public class EmprendimientoController {

    private EmprendimientoRepository repository;

    @Autowired
    public EmprendimientoController(EmprendimientoRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity <?> obtenerEmprendimientos() {
        return new ResponseEntity(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Emprendimiento emprendimiento){
        return new ResponseEntity(repository.save(emprendimiento),HttpStatus.CREATED);
    }
}
