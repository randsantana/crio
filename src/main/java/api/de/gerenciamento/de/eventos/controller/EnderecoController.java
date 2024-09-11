package api.de.gerenciamento.de.eventos.controller;
import api.de.gerenciamento.de.eventos.dumain.endereco.Endereco;
import api.de.gerenciamento.de.eventos.dumain.endereco.EnderecoRequestoDTO;
import api.de.gerenciamento.de.eventos.dumain.endereco.EnderecoResponseDTO;
import api.de.gerenciamento.de.eventos.dumain.evento.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.de.gerenciamento.de.eventos.service.EnderecoService;


import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Endereco> create(
            //mapeamento dos campos
            @RequestParam("city") String city,
            @RequestParam("uf")String uf,
            @RequestParam("evento")Evento evento
    ) {

        EnderecoRequestoDTO enderecoRequestDTO = new EnderecoRequestoDTO(city,uf,evento);
        Endereco newEndereco = this.enderecoService.createEndereco(enderecoRequestDTO);
        return ResponseEntity.ok(newEndereco);
    }
    @GetMapping
    public  ResponseEntity<List<Endereco>> getAllEndereco(){
        List<Endereco> enderecos = this.enderecoService.getAllEndereco();
        return ResponseEntity.ok(enderecos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable("id") UUID id){
        Endereco endereco = this.enderecoService.getEnderecoById(id);
        return ResponseEntity.ok(endereco);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Endereco> UpdateEndereco(
            @PathVariable("id")UUID id, EnderecoRequestoDTO enderecoRequestDTO){
        Endereco updateEndereco = this.enderecoService.updateEndereco(id, enderecoRequestDTO);
        return  ResponseEntity.ok(updateEndereco);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable("id")UUID id){
        this.enderecoService.deleteEndereco(id);
        return  ResponseEntity.noContent().build();
    }
}
