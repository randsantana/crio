package repository;

import dumain.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventoRepository extends JpaRepository<Evento, UUID> {
    //findEventosbyTitle() implementar
    //findEventosbyDate()
}
