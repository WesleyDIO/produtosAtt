package api.produtos.api.controller;

import api.produtos.api.exceptions.DadosInvalidosException;
import api.produtos.api.exceptions.ErroInternoException;
import api.produtos.api.exceptions.FabricanteExistenteException;
import api.produtos.api.exceptions.FabricanteNaoEncontradoException;
import api.produtos.api.model.Fabricante;
import api.produtos.api.service.FabricanteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

    private FabricanteService fabricanteService;

    @GetMapping()
    public ResponseEntity<List<Fabricante>> buscarTodos() {
        try {
            return new ResponseEntity<>(fabricanteService.buscarTodos(), HttpStatus.OK);
        } catch (ErroInternoException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> buscarUm(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(fabricanteService.buscarUm(id), HttpStatus.OK);
        } catch (FabricanteNaoEncontradoException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ErroInternoException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Fabricante> salvar(@RequestBody Fabricante fabricante) {
        try {
            return new ResponseEntity<>(fabricanteService.salvar(fabricante), HttpStatus.OK);
        } catch (FabricanteExistenteException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        fabricanteService.deletar(id);
    }

    @PutMapping
    public ResponseEntity<Fabricante> atualizar(@RequestBody Fabricante fabricanteNovo) {
        try {
            return new ResponseEntity<>(fabricanteService.editar(fabricanteNovo), HttpStatus.OK);
        } catch (DadosInvalidosException e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
