package api.de.gerenciamento.de.eventos.dumain.convite;

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
@Table(name = "convite")
@Entity
public class Convite {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    private boolean confirmacao_presenca;
}
