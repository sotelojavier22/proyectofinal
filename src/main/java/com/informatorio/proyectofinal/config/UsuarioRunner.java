package com.informatorio.proyectofinal.config;

import com.informatorio.proyectofinal.entity.Emprendimiento;
import com.informatorio.proyectofinal.entity.Evento;
import com.informatorio.proyectofinal.entity.Usuario;
import com.informatorio.proyectofinal.entity.Voto;
import com.informatorio.proyectofinal.repository.EmprendimientoRepository;
import com.informatorio.proyectofinal.repository.EventoRepository;
import com.informatorio.proyectofinal.repository.UsuarioRepository;
import com.informatorio.proyectofinal.repository.VotoRepository;
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
    @Autowired
    private VotoRepository votoRepository;

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

        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Karina");
        usuario1.setApellido("Vargas");
        usuario1.setCiudad("Formosa");
        usuario1.setEmail("karinavargas@gmail.com");
        usuario1.setPais("Argentina");
        usuario1.setPassword("123456");
        usuario1.setProvincia("Formosa");
        usuario1.setTipo("COLABORADOR");
        usuario1 = usuarioRepository.save(usuario1);

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

        Voto voto = new Voto();
        voto.setUsuario("karinavargas@gmail.com");
        voto.setGeneradoPor("Web");
        voto = votoRepository.save(voto);

        Voto voto1 = new Voto();
        voto1.setUsuario("karinavargas@gmail.com");
        voto1.setGeneradoPor("Web");
        voto1 = votoRepository.save(voto1);

        Voto voto2 = new Voto();
        voto2.setUsuario("sotelojavier22@gmail.com");
        voto2.setGeneradoPor("Web");
        voto2 = votoRepository.save(voto2);

    }
}
