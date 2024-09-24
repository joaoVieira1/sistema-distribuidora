package Repositorys;

import Errors.ValorInvalido;
import Services.Pedido;
import java.util.ArrayList;

public class Pedidos {
    
    private ArrayList<Pedido> pedidos;
    private static Pedidos instancia;
    
    private Pedidos(){
        this.pedidos = new ArrayList<>();
    }
    
    public static Pedidos getInstancia(){
        if(instancia == null){
            instancia = new Pedidos();
        }
        
        return instancia;
    }
    
    public void cadastrarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    
    public void removerPedido(Pedido pedido){
        if(pedidos.contains(pedido)){
            pedidos.remove(pedido);
        }else{
            throw new ValorInvalido("Pedido não existente");
        }
    }
    
    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }

    @Override
    public String toString() {
        return "" + pedidos;
    }
    
    
    
}
