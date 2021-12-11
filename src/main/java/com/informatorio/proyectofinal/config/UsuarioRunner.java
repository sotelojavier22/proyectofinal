package com.informatorio.proyectofinal.config;

import com.informatorio.proyectofinal.entity.Usuario;
import com.informatorio.proyectofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRunner implements CommandLineRunner {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("Javier");
        usuario.setApellido("Sotelo");
        usuario.setCiudad("Resistencia");
        usuario.setEmail("sotelojavier22@gmail.com");
        usuario.setPais("Argentina");
        usuario.setPassword("123456");
        usuario.setProvincia("Chaco");
        usuario.setTipo("OWNER");
        usuario = usuarioRepository.save(usuario);

    }
}
