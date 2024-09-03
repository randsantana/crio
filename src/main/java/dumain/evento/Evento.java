package dumain.evento;

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

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "inicio")
    private LocalDateTime inicio;

    @Column(name = "fim")
    private LocalDateTime fim;

    @Column(name = "local")
    private String local;

    @Column(name = "privado")
    private boolean privado;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private int usuario_id;
}
