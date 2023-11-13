package api.produtos.api.exceptions;

public class CategoriaExistenteException extends RuntimeException{

    public CategoriaExistenteException() {
        super("Categoria já existe");
    }
}
