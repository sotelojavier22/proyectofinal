package com.informatorio.proyectofinal.service;

import com.informatorio.proyectofinal.dto.EventoDto;
import com.informatorio.proyectofinal.entity.Evento;
import com.informatorio.proyectofinal.repository.EventoRepository;
import org.springframework.core.convert.converter.Converter;


public class EventoService {
    private final Converter<EventoDto, Evento> eventoDtoEventoConverter;
    private final EventoRepository eventoRepository;

    public EventoService(Converter<EventoDto, Evento> eventoDtoEventoConverter, EventoRepository eventoRepository) {
        this.eventoDtoEventoConverter = eventoDtoEventoConverter;
        this.eventoRepository = eventoRepository;
    }


}
