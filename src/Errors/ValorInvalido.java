package Errors;

public class ValorInvalido extends IllegalArgumentException{
    public ValorInvalido(String mensagem) {
        super(mensagem);
    }
}
