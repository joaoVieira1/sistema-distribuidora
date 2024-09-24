package Strategy;

public class EntregaMoto implements EntregaEstrategia{
    @Override
    public String rota(String origem, String destino) {
        return "motorista sai do " + origem + "passa pelo centro a fim de encurtar caminho ate " + destino;
    }
}
