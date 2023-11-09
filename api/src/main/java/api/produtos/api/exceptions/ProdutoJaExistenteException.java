package api.produtos.api.exceptions;

public class ProdutoJaExistenteException extends Exception{
    public ProdutoJaExistenteException() {
        super("Produto já existe no estoque");
    }
}
