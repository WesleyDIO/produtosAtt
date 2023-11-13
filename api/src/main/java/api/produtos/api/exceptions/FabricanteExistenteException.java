package api.produtos.api.exceptions;

public class FabricanteExistenteException extends RuntimeException{

    public FabricanteExistenteException() {
        super("Fabricante já existe");
    }
}
