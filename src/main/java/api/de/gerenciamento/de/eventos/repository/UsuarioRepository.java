package api.de.gerenciamento.de.eventos.repository;

import api.de.gerenciamento.de.eventos.dumain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    //selecione todos os usuarios
    @Query("SELECT u FROM Usuario u")
    List<Usuario> findAllUsuario();
    //selecionar o seu usuario pelo seu id
    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    Optional<Usuario> findByIdUsuario(UUID id);
    //Salvar um usuario
    @Query("INSERT INTO Usuario(nomeCompleto, email, senha, tipo,createdAt, updatedAt)VALUES(:nomeCompleto, :email, :senha, :tipo,:createdAt, :updatedAt)")
    Usuario saveUsuario(String nomeCompleto, String email, String senha, int tipo,LocalDateTime createdAt, LocalDateTime updatedAt);
//    //Atualizar usuario
    @Query("UPDATE Usuario u SET u.nomeCompleto=:nomeCompleto, "+
     "u.email=:email, u.senha=:senha, u.tipo=:tipo, u.updatedAt=:updatedAt WHERE u.id = :id")
    void updateUsuario(UUID id, String nomeCompleto, String email, String senha, int tipo,
                LocalDateTime updatedAt);
    //deletar usuario
    @Query("DELETE FROM Usuario u WHERE u.id = :id")
    void deleteByIdUsuario(UUID id);
}
