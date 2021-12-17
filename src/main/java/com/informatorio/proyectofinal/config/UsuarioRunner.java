package com.informatorio.proyectofinal.config;

import com.informatorio.proyectofinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    @Autowired
    private TagRepository tagRepository;

    @Override
    public void run(String... args) throws Exception {
       /*
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
        usuario1.setTipo("USUARIO");
        usuario1 = usuarioRepository.save(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Jorge");
        usuario2.setApellido("Garcia");
        usuario2.setCiudad("Resistencia");
        usuario2.setEmail("jorgegarcia@gmail.com");
        usuario2.setPais("Argentina");
        usuario2.setPassword("159753");
        usuario2.setProvincia("Chaco");
        usuario2.setTipo("USUARIO");
        usuario2 = usuarioRepository.save(usuario2);


        Evento evento = new Evento();
        evento.setDetallesEvento("Para participantes del informatorio 2021. Premio de $100000");
        evento.setEstado("ABIERTO");
        evento.setFechaApertura(LocalDate.parse("2021-12-16"));
        evento.setPremio(BigDecimal.valueOf(100000));
        //evento.setFechaCierre();

        evento = eventoRepository.save(evento);

        Voto voto = new Voto();
        voto.setUsuario("karinavargas@gmail.com");
        voto.setGeneradoPor("Web");
        //voto = votoRepository.save(voto);

        Voto voto1 = new Voto();
        voto1.setUsuario("jorgegarcia@gmail.com");
        voto1.setGeneradoPor("Web");
        //voto1 = votoRepository.save(voto1);

        Voto voto2 = new Voto();
        voto2.setUsuario("sotelojavier22@gmail.com");
        voto2.setGeneradoPor("Web");
        //voto2 = votoRepository.save(voto2);

        Tag tag = new Tag();
        tag.setNombre("Juegos");
        //tag = tagRepository.save(tag);

        Emprendimiento emprendimiento = new Emprendimiento();
        emprendimiento.setNombre("TriviaChaco");
        emprendimiento.setDescripcion("Aplicación de preguntas y respuestas");
        emprendimiento.setContenido("Aplicación de preguntas y respuestas sobre la provincialización del Chaco");
        emprendimiento.setObjetivo(BigDecimal.valueOf(25000));
        emprendimiento.setPublicado(Boolean.TRUE);
        emprendimiento.setVotos(List.of(voto,voto1,voto2));
        emprendimiento.agregarTag(tag);
        emprendimiento = emprendimientoRepository.save(emprendimiento);
        voto.setEmprendimiento(emprendimiento);
        voto = votoRepository.save(voto);
        voto1.setEmprendimiento(emprendimiento);
        voto1 = votoRepository.save(voto1);
        voto2.setEmprendimiento(emprendimiento);
        voto2 = votoRepository.save(voto2);
    */
    }
}
