package api.produtos.api.exceptions;

public class CategoriaNaoEncontradaException extends RuntimeException{

    public CategoriaNaoEncontradaException() {
        super("Categoria não encontrada");
    }
}
