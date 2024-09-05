package api.de.gerenciamento.de.eventos.repository;

import api.de.gerenciamento.de.eventos.dumain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
