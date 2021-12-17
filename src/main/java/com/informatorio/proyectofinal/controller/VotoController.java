package com.informatorio.proyectofinal.controller;

import com.informatorio.proyectofinal.entity.Emprendimiento;
import com.informatorio.proyectofinal.entity.Voto;
import com.informatorio.proyectofinal.repository.EmprendimientoRepository;
import com.informatorio.proyectofinal.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
public class VotoController {

    private VotoRepository repository;
    private EmprendimientoRepository emprendimientoRepository;

    @Autowired
    public VotoController(VotoRepository repository, EmprendimientoRepository emprendimientoRepository) {
        this.repository = repository;
        this.emprendimientoRepository = emprendimientoRepository;
    }

    @GetMapping(value = "/voto")
    public ResponseEntity<?> findVotos(@RequestParam(name = "usuario",required = false) String usuario) {
        if (usuario != null){
            return new ResponseEntity(repository.findByUsuario(usuario),HttpStatus.OK);
        }
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/emprendimiento/{idEmp}/voto")
    public  ResponseEntity<?> crear(@PathVariable("idEmp") Long idEmp, @RequestBody Voto voto){
        Emprendimiento emprendimiento = emprendimientoRepository
                .findById(idEmp)
                .orElseThrow(() -> new EntityNotFoundException("Emprendimiento no encontrado"));
        voto.setEmprendimiento(emprendimiento);

        return new ResponseEntity<>(repository.save(voto),HttpStatus.CREATED);
    }
}
