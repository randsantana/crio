package api.de.gerenciamento.de.eventos.controller;

import api.de.gerenciamento.de.eventos.dumain.usuario.Usuario;
import api.de.gerenciamento.de.eventos.dumain.usuario.UsuarioRequestDTO;
import api.de.gerenciamento.de.eventos.dumain.usuario.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.de.gerenciamento.de.eventos.service.UsuarioService;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    //CRUD
    @PostMapping("/save")//  /api/usuario/save
    public Usuario saveUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        return usuarioService.saveUsuario(
                usuarioRequestDTO.nomeCompleto(),
                usuarioRequestDTO.email(),
                usuarioRequestDTO.senha(),
                usuarioRequestDTO.tipo(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Usuario> create(
            //mapeamento dos campos
            @RequestParam("nomeCompleto") String nomeCompleto,
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            @RequestParam("tipo") int tipo) {
        UsuarioRequestDTO usuarioRequestDTO = new UsuarioRequestDTO(nomeCompleto, email, senha, tipo);
        Usuario newUsuario = this.usuarioService.createUsuario(usuarioRequestDTO);
        return ResponseEntity.ok(newUsuario);
    }
    @GetMapping
    public  ResponseEntity<List<Usuario>> getAllUsers(){
        List<Usuario> usuarios = this.usuarioService.getAllUsers();
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id")UUID id){
        Usuario usuario = this.usuarioService.getUserById(id);
        return ResponseEntity.ok(usuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> UpdateUser(
            @PathVariable("id")UUID id, UsuarioRequestDTO usuarioRequestDTO){
        Usuario updateUsuario = this.usuarioService.updateUser(id,usuarioRequestDTO);
        return  ResponseEntity.ok(updateUsuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id")UUID id){
        this.usuarioService.deleteUser(id);
        return  ResponseEntity.noContent().build();
    }
}