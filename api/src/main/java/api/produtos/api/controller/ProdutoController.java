package api.produtos.api.controller;

import api.produtos.api.exceptions.DadosInvalidosException;
import api.produtos.api.exceptions.ErroInternoException;
import api.produtos.api.exceptions.ProdutoJaExistenteException;
import api.produtos.api.exceptions.ProdutoNaoExistenteException;
import api.produtos.api.model.Produto;
import api.produtos.api.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<List<Produto>>  buscarTodos() {
        try {
            return new ResponseEntity<>(produtoService.buscarTodos(), HttpStatus.OK);
        }catch (ErroInternoException e){
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarUm(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>( produtoService.buscarUm(id), HttpStatus.OK);
        }catch (ProdutoNaoExistenteException e){
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (ErroInternoException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping()
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        try {
            return new ResponseEntity<>(produtoService.salvar(produto), HttpStatus.OK);
        }catch (ProdutoJaExistenteException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
    }
    @PutMapping
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produtoNovo){
        try {
            return new ResponseEntity<>(produtoService.editar(produtoNovo), HttpStatus.OK);
        }catch (DadosInvalidosException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
