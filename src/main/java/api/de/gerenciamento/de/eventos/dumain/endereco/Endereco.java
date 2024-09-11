package api.de.gerenciamento.de.eventos.dumain.endereco;

import api.de.gerenciamento.de.eventos.dumain.evento.Evento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "endereco")
@Entity
public class Endereco {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    private String city;
    @Column(length = 2)
    private String uf;

    @OneToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
}
