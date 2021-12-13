package com.informatorio.proyectofinal.config;

import com.informatorio.proyectofinal.entity.Emprendimiento;
import com.informatorio.proyectofinal.entity.Evento;
import com.informatorio.proyectofinal.entity.Usuario;
import com.informatorio.proyectofinal.repository.EmprendimientoRepository;
import com.informatorio.proyectofinal.repository.EventoRepository;
import com.informatorio.proyectofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UsuarioRunner implements CommandLineRunner {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EmprendimientoRepository emprendimientoRepository;
    @Autowired
    private EventoRepository eventoRepository;

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

        Emprendimiento emprendimiento = new Emprendimiento();
        emprendimiento.setNombre("TriviaChaco");
        emprendimiento.setDescripcion("Aplicación de preguntas y respuestas");
        emprendimiento.setContenido("Aplicación de preguntas y respuestas sobre la provincialización del Chaco");
        emprendimiento.setObjetivo(BigDecimal.valueOf(25000));
        emprendimiento.setPublicado(Boolean.TRUE);

        emprendimiento = emprendimientoRepository.save(emprendimiento);

        Evento evento = new Evento();
        evento.setDetallesEvento("Para participantes del informatorio 2021. Premio de $100000");
        evento.setEstado("ABIERTO");
        //evento.setFechaApertura();
        evento.setPremio(BigDecimal.valueOf(100000));
        //evento.setFechaCierre();

        evento = eventoRepository.save(evento);


    }
}
