package api.de.gerenciamento.de.eventos.dumain.evento;

import api.de.gerenciamento.de.eventos.dumain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "evento")
@Entity
public class Evento {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    private String titulo;
    private String descricao;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private boolean privado;
    private String linkEvento;
    private String comoChegar;
    private String linkForms;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

}
