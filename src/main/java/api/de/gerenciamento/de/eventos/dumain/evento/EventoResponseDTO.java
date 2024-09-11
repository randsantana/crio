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
        boolean privado,
        String linkEvento,
        String comoChegar,
        String linkForm,
        Usuario usuario
){
}
