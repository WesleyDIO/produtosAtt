package api.produtos.api.service;

import api.produtos.api.exceptions.DadosInvalidosException;
import api.produtos.api.exceptions.ProdutoJaExistenteException;
import api.produtos.api.exceptions.ProdutoNaoExistenteException;
import api.produtos.api.model.Produto;
import api.produtos.api.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {
    ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }
    public Produto buscarUm(Integer id) throws ProdutoNaoExistenteException {
        if (!produtoRepository.existsById(id)) {
            throw new ProdutoNaoExistenteException();
        }
        return produtoRepository.findById(id).get();
    }
    public Produto salvar(Produto produto) throws ProdutoJaExistenteException {
        if (produtoRepository.existsById(produto.getId())){
            throw new ProdutoJaExistenteException();
        }
        return produtoRepository.save(produto);
    }
    public Produto editar(Produto produto) throws DadosInvalidosException {
        if (!produtoRepository.existsById(produto.getId())){
            throw new DadosInvalidosException();
        }
        return produtoRepository.save(produto);
    }
    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }
}
