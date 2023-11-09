package api.produtos.api.exceptions;

public class ErroInternoException extends RuntimeException {

    public ErroInternoException(String message) {
        super("Erro interno no servidor");
    }
}
