package api.de.gerenciamento.de.eventos.dumain.usuario;

import java.util.UUID;

public record UsuarioRequestDTO(
        UUID id,
        String nomeCompleto,
        String email,
        String senha,
        int tipo
){
}
