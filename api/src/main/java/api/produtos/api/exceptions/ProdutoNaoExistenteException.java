package api.produtos.api.exceptions;

public class ProdutoNaoExistenteException extends Exception{
        public ProdutoNaoExistenteException() {
            super("Produto não encontrado");
        }
}
