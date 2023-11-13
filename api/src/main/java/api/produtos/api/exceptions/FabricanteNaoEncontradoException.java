package api.produtos.api.exceptions;

public class FabricanteNaoEncontradoException extends RuntimeException{

    public FabricanteNaoEncontradoException(String message) {
        super("Fabricante não encontrado");
    }
}
