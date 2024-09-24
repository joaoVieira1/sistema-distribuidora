package Strategy;

//Implementando padrao de projeto comportamental Strategy, para abstrair a entrega de acordo com o tipo de entrega a ser realizado.
public class Entrega {

    private EntregaEstrategia entrega;

    public Entrega(EntregaEstrategia entrega) {
        setEntrega(entrega);
    }

    public EntregaEstrategia getEntrega() {
        return entrega;
    }

    public void setEntrega(EntregaEstrategia entrega) {
        this.entrega = entrega;
    }

    public String entrega(String origem, String destino){
        return entrega.rota(origem,destino);
    }
}
