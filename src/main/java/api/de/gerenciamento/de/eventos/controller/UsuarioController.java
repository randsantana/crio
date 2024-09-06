package api.de.gerenciamento.de.eventos.controller;

import api.de.gerenciamento.de.eventos.dumain.usuario.Usuario;
import api.de.gerenciamento.de.eventos.dumain.usuario.UsuarioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import api.de.gerenciamento.de.eventos.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping(consumes = "multipart/from-data")
    public ResponseEntity<Usuario> create(
            //mapeamento dos campos
            @RequestParam("nomecompleto") String nomeCompleto,
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            @RequestParam("tipo") int tipo) {
        UsuarioRequestDTO usuarioRequestDTO = new UsuarioRequestDTO(nomeCompleto, email, senha, tipo);
        Usuario newUsuario = this.usuarioService.createUsuario(usuarioRequestDTO);
        return ResponseEntity.ok(newUsuario);
    }
}