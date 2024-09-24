package Repositorys;

import Errors.FaltaEmEstoque;
import java.util.HashMap;

public class EstoqueProdutos<T> {
    
    private HashMap<T, Integer> estoque;
    private static EstoqueProdutos instancia;
    
    public EstoqueProdutos(){
        estoque = new HashMap<>();
    }
    
    //Adicionando o padrão criacional Singleton pois a distribuidora contará com apenas um estoque geral
    public static EstoqueProdutos getInstancia(){
        if(instancia == null){
            instancia = new EstoqueProdutos();
        }
        
        return instancia;
    }
    
    public void adicionarProduto(T produto, int quantidade){
        
        if(estoque.containsKey(produto)){
            int quantidadeEstocada = quantidade(produto);
            estoque.put(produto, quantidade + quantidadeEstocada);
        }else{
            estoque.put(produto, quantidade);
        }
        
    }
    
    public void remover(T produto, int quantidade){
        
        if(estoque.containsKey(produto)){
            int quantidadeEstocada = quantidade(produto);
            
            if(quantidadeEstocada == quantidade){
                estoque.remove(produto);
            }else if(quantidadeEstocada > quantidade){
                estoque.put(produto, quantidadeEstocada - quantidade);
            }else{
                throw new FaltaEmEstoque("Produto está em falta ou não existe no estoque, impossível a remoção.");
            }
        }else{
            throw new FaltaEmEstoque("Produto está em falta ou não existe no estoque, impossível a remoção.");
        }
        
    }
    
    public int quantidade(T produto){
        int quantidadeEstoque = 0;
        
        if(estoque.containsKey(produto)){
            quantidadeEstoque = estoque.get(produto);
        }else{
            throw new FaltaEmEstoque("O produto está em falta ou não existe no estoque.");
        }
        
        return quantidadeEstoque;
    }

    @Override
    public String toString() {
        String str = "ESTOQUE\n";
        
        for(T produto : estoque.keySet()){
            str = str.concat(produto + "Quantidade: " + estoque.get(produto) + "\n");
        }
        
        return str;
    }
    
}
