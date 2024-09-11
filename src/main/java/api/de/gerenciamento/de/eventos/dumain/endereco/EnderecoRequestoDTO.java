package api.de.gerenciamento.de.eventos.dumain.endereco;

import api.de.gerenciamento.de.eventos.dumain.evento.Evento;

public record EnderecoRequestoDTO (
        String city,
        String uf,
        Evento evento
){
}
