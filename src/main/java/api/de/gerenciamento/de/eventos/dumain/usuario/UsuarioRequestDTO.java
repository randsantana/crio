package api.de.gerenciamento.de.eventos.dumain.usuario;

public record UsuarioRequestDTO(
        String nomeCompleto,
        String email,
        String senha,
        int tipo
){
}
