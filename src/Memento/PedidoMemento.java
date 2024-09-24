package Memento;

import Models.PedidoProduto;
import Services.Pedido;

import java.util.ArrayList;

//Implementando padrao comportamental de projeto Memento, para a implementacao do metodo Pedido.restaurar().
public class PedidoMemento {

    private Pedido pedido;
    private ArrayList<PedidoProduto> produtos;

    public PedidoMemento(Pedido pedido) {
        this.pedido = pedido;
        this.produtos = pedido.getProdutos();
    }

    public void restaurar(){
        pedido.setProdutos(produtos);
    }

    @Override
    public String toString() {
        return "" + produtos;
    }
}
