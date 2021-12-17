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
    public ResponseEntity <?> obtenerEmprendimientos(@RequestParam(name = "publicado",required = false)
                                                     Boolean publicado) {
        if (publicado != null) {
            return new ResponseEntity(repository.findByPublicado(publicado),HttpStatus.OK);
        }
        return new ResponseEntity(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Emprendimiento obtenerEmprendimientoPorId(@PathVariable("id") Long id){
        return repository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<?> crearEmprendimiento(@RequestBody Emprendimiento emprendimiento){
        return new ResponseEntity(repository.save(emprendimiento),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Emprendimiento modificarEmprendimiento(@PathVariable("id") Long id,@RequestBody Emprendimiento emprendimiento){
        Emprendimiento empExistente = repository.findById(id).get();
        empExistente.setNombre(emprendimiento.getNombre());
        empExistente.setDescripcion(emprendimiento.getDescripcion());
        empExistente.setContenido(emprendimiento.getContenido());
        empExistente.setPublicado(emprendimiento.getPublicado());
        return repository.save(empExistente);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void eliminarEmprendimiento(@PathVariable("id") Long id){
        repository.deleteById(id);
    }
}
