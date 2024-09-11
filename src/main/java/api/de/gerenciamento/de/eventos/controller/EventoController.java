package api.de.gerenciamento.de.eventos.controller;
import api.de.gerenciamento.de.eventos.dumain.evento.Evento;
import api.de.gerenciamento.de.eventos.dumain.evento.EventoRequestDTO;
import api.de.gerenciamento.de.eventos.dumain.usuario.Usuario;
import api.de.gerenciamento.de.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/evento")
public class EventoController{
    @Autowired
    private EventoService eventoService;

    @PostMapping(consumes = "multipart/form-data")
public ResponseEntity<Evento> create(
        //mapeamento dos campos
        @RequestParam("titulo") String titulo,
        @RequestParam("descricao")String descricao,
        @RequestParam("inicio")LocalDateTime inicio,
        @RequestParam("fim") LocalDateTime fim,
        @RequestParam("privado") boolean privado,
        @RequestParam("linkEvento") String linkEvento,
        @RequestParam("comoChegar") String comoChegar,
        @RequestParam("linkForms") String linkForms,
        @RequestParam("usuario") Usuario usuario
    ) {
    EventoRequestDTO eventoRequestDTO = new EventoRequestDTO(titulo, descricao, inicio, fim, privado, linkEvento, comoChegar, linkForms, usuario);
    Evento newEvento = this.eventoService.createEvento(eventoRequestDTO);
    return ResponseEntity.ok(newEvento);
}
@GetMapping
public  ResponseEntity<List<Evento>> getAllEvento(){
    List<Evento> eventos = this.eventoService.getAllEvento();
    return ResponseEntity.ok(eventos);
}
@GetMapping("/{id}")
public ResponseEntity<Evento> getEventoById(@PathVariable("id")UUID id){
    Evento evento = this.eventoService.getEventoById(id);
    return ResponseEntity.ok(evento);
}
@PutMapping("/{id}")
public ResponseEntity<Evento> UpdateEvento(
        @PathVariable("id")UUID id, EventoRequestDTO eventoRequestDTO){
    Evento updateEvento = this.eventoService.updateEvento(id, eventoRequestDTO);
    return  ResponseEntity.ok(updateEvento);
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteEvento(@PathVariable("id")UUID id){
    this.eventoService.deleteEvento(id);
    return  ResponseEntity.noContent().build();
}
}
