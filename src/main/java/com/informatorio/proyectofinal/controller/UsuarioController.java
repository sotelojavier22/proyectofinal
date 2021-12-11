package com.informatorio.proyectofinal.controller;

import com.informatorio.proyectofinal.entity.Usuario;
import com.informatorio.proyectofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public @ResponseBody Iterable<Usuario> findUsuarios(){
        return repository.findAll();
    }
}
