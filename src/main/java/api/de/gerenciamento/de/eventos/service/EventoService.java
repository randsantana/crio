package api.de.gerenciamento.de.eventos.service;

import api.de.gerenciamento.de.eventos.dumain.evento.Evento;
import api.de.gerenciamento.de.eventos.dumain.evento.EventoRequestDTO;
import api.de.gerenciamento.de.eventos.dumain.usuario.Usuario;
import api.de.gerenciamento.de.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public Evento createEvento(EventoRequestDTO data){
        //cria um Evento vazio
        Evento newEvento = new Evento();
        newEvento.setTitulo(data.titulo());
        newEvento.setDescricao(data.descricao());
        newEvento.setInicio(data.inicio());
        newEvento.setFim(data.fim());
        newEvento.setLocal(data.local());
        newEvento.setPrivado(data.privado());
        eventoRepository.save(newEvento);
        return newEvento;

    }

    public List<Evento> getAllEvento() {
        return eventoRepository.findAll();
    }

    public Evento getEventoById(UUID id) {
        return eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado."));
    }

    public Evento updateEvento(UUID id, EventoRequestDTO eventoRequestDTO) {
        Evento updateEvento = getEventoById(id);
        updateEvento.setTitulo(eventoRequestDTO.titulo());
        updateEvento.setDescricao(eventoRequestDTO.descricao());
        updateEvento.setInicio(eventoRequestDTO.inicio());
        updateEvento.setFim(eventoRequestDTO.fim());
        updateEvento.setLocal(eventoRequestDTO.local());
        updateEvento.setPrivado(eventoRequestDTO.privado());
        return eventoRepository.save(updateEvento);
    }
    public void deleteEvento(UUID id){
        Evento evento = getEventoById(id);
        eventoRepository.delete(evento);
    }
}
