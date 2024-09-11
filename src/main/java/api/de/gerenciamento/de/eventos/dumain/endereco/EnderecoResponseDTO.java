package api.de.gerenciamento.de.eventos.dumain.endereco;

import api.de.gerenciamento.de.eventos.dumain.evento.Evento;

import java.util.UUID;

public record EnderecoResponseDTO (
        UUID id,
        String city,
        String uf,
        Evento evento
){
}
