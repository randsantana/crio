package api.de.gerenciamento.de.eventos.service;

import api.de.gerenciamento.de.eventos.dumain.endereco.Endereco;
import api.de.gerenciamento.de.eventos.dumain.endereco.EnderecoRequestoDTO;
import api.de.gerenciamento.de.eventos.dumain.endereco.EnderecoResponseDTO;
import api.de.gerenciamento.de.eventos.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco createEndereco(EnderecoRequestoDTO data){
        //cria um Endereco vazio
        Endereco newEndereco = new Endereco();
        newEndereco.setCity(data.city());
        newEndereco.setUf(data.uf());
        enderecoRepository.save(newEndereco);
        return newEndereco;
    }

    public List<Endereco> getAllEndereco() {
        return enderecoRepository.findAll();
    }

    public Endereco getEnderecoById(UUID id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereco não encontrado."));
    }

    public Endereco updateEndereco(UUID id, EnderecoRequestoDTO enderecoRequestoDTO) {
        Endereco updateEndereco = getEnderecoById(id);
        updateEndereco.setCity(enderecoRequestoDTO.city());
        updateEndereco.setUf(enderecoRequestoDTO.uf());

        return enderecoRepository.save(updateEndereco);
    }
    public void deleteEndereco(UUID id){
        Endereco Endereco = getEnderecoById(id);
        enderecoRepository.delete(Endereco);
    }
}
