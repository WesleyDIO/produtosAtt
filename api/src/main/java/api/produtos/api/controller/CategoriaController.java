package api.produtos.api.controller;

import api.produtos.api.exceptions.CategoriaExistenteException;
import api.produtos.api.exceptions.CategoriaNaoEncontradaException;
import api.produtos.api.exceptions.DadosInvalidosException;
import api.produtos.api.exceptions.ErroInternoException;
import api.produtos.api.model.Categoria;
import api.produtos.api.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity<List<Categoria>> buscarTodos() {
        try {
            return new ResponseEntity<>(categoriaService.buscarTodos(), HttpStatus.OK);
        } catch (ErroInternoException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarUm(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(categoriaService.buscarUm(id), HttpStatus.OK);
        } catch (CategoriaNaoEncontradaException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ErroInternoException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
        try {
            return new ResponseEntity<>(categoriaService.salvar(categoria), HttpStatus.OK);
        } catch (CategoriaExistenteException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        categoriaService.deletar(id);
    }

    @PutMapping
    public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoriaNova) {
        try {
            return new ResponseEntity<>(categoriaService.editar(categoriaNova), HttpStatus.OK);
        } catch (DadosInvalidosException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
