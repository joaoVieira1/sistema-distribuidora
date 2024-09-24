package Strategy;

public class EntregaCarro implements EntregaEstrategia{
    @Override
    public String rota(String origem, String destino) {
        return  "motorista sai do " + origem + " passa pela periferia para evitar o transito da cidade ate a rua " + destino;
    }
}
