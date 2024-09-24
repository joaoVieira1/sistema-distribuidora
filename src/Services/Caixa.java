package Services;

import Models.enums.Status;
import Repositorys.Pedidos;


public class Caixa {
  
    
    public static void FaturamentoTotal(Pedidos pedidos){
        
        double faturamentoTotal = 0.0;
        
        for(Pedido p : pedidos.getPedidos()){
           
            if(p.getStatusPedido() == Status.FINALIZADO){
                faturamentoTotal += p.getValorTotal();
            }
            
        }
        
        System.out.println(faturamentoTotal);
    }
    
    
    
}
