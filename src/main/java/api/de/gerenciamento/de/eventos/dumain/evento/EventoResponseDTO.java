package api.de.gerenciamento.de.eventos.dumain.evento;

import api.de.gerenciamento.de.eventos.dumain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventoResponseDTO (
        UUID id,
        String titulo,
        String descricao,
        LocalDateTime inicio,
        LocalDateTime fim,
        String local,
        boolean privado,
        Usuario usuario
){
}
