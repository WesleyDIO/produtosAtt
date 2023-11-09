package api.produtos.api.exceptions;

public class DadosInvalidosException extends Exception{
    public DadosInvalidosException() {
        super("Dados invalidos ou falta de informação");
    }
}
