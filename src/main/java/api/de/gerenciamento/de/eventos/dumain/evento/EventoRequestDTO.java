package api.de.gerenciamento.de.eventos.dumain.evento;

import api.de.gerenciamento.de.eventos.dumain.usuario.Usuario;

import java.time.LocalDateTime;

public record EventoRequestDTO (
        String titulo,
        String descricao,
        LocalDateTime inicio,
        LocalDateTime fim,
        String local,
        boolean privado,
        Usuario usuario
){
}
