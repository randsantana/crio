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
    @Query("SELECT u FROM usuario u")
    List<Usuario> findAll();
    //selecionar o seu usuario pelo seu id
    @Query("SELECT u FROM usuario u WHERE u.id = :id")
    Optional<Usuario> findById(UUID id);
    //Salvar um usuario
    @Query("INSERT INTO usuario(nomeCompleto, email, senha, tipo," +
             "createAt, updateAt)VALUES(:nomeCompleto, :email, :senha, :tipo" + "createAt, :updateAt)")
    Usuario save(String nomeCompleto, String email, String senha, int tipo,
                 LocalDateTime createAt, LocalDateTime updateAt);
    //Atualizar usuario
    @Query("UPDATE usuario u SET u.nomeCompleto=:nomeCompleto, "+
     "u.email=:email, u.senha=:senha, u.tipo=:tipo, "+
     "u.updateAt=:updateAt WHERE u.id = :id")
    void update(UUID id, String nomeCompleto, String email, String senha, int tipo,
                LocalDateTime updateAt);
    //deletar usuario
    @Query("DELETE DROM usuario u WHERE u.id = :id")
    void deleteById(UUID id);
}
