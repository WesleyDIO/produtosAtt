package api.produtos.api.service;

import api.produtos.api.exceptions.DadosInvalidosException;
import api.produtos.api.model.Categoria;
import api.produtos.api.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarUm(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria editar(Categoria categoria) throws DadosInvalidosException {
        if (!categoriaRepository.existsById(categoria.getId())){
            throw new DadosInvalidosException();
        }
        return categoriaRepository.save(categoria);
    }

    public void deletar(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
