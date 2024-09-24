
package Errors;

public class EnderecoInvalido extends Exception{
    private String mensagem;

    public EnderecoInvalido(String mensagem) {
        super(mensagem);
    }
    
}
