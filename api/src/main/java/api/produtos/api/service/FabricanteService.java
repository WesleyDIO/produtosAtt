package api.produtos.api.service;

import api.produtos.api.exceptions.DadosInvalidosException;
import api.produtos.api.model.Fabricante;
import api.produtos.api.repository.FabricanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FabricanteService {

    private FabricanteRepository fabricanteRepository;

    public List<Fabricante> buscarTodos() {
        return fabricanteRepository.findAll();
    }

    public Fabricante buscarUm(Integer id) {
        return fabricanteRepository.findById(id).orElse(null);
    }

    public Fabricante salvar(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

    public Fabricante editar(Fabricante fabricante) throws DadosInvalidosException {
        if (!fabricanteRepository.existsById(fabricante.getId())){
            throw new DadosInvalidosException();
        }
        return fabricanteRepository.save(fabricante);
    }

    public void deletar(Integer id) {
        fabricanteRepository.deleteById(id);
    }
}
