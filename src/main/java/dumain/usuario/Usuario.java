package dumain.usuario;

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
@Table(name = "usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private UUID id;
    private String nomeCompleto;
    private String email;
    private String senha;
    private int tipo;
    private LocalDateTime createdAT;
    private LocalDateTime updatedAT;

}
