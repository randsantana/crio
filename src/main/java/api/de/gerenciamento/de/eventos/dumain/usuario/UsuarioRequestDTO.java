package api.de.gerenciamento.de.eventos.dumain.usuario;

import java.util.UUID;

public record UsuarioRequestDTO(
        String nomeCompleto,
        String email,
        String senha,
        int tipo
){
}
