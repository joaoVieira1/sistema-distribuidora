package Errors;

public class FaltaEmEstoque extends RuntimeException{
    public FaltaEmEstoque(String mensagem){
        super(mensagem);
    }
}
