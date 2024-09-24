package Models.enums;

public enum TipoPedido {
    RETIRADA(1),
    ENTREGA(2);

    private int valor;
    TipoPedido(int valor) {
        this.valor = valor;
    }
}
