package Models;

import Errors.QuantidadeInvalida;

public class PedidoProduto {
    
    private Produto produto;
    private int quantidade;
    private double valorItem;

    public PedidoProduto(Produto produto, int quantidade){
        setProduto(produto);
        setQuantidade(quantidade);
        this.valorItem = calcularValorItem();
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade <= 0){
            throw new QuantidadeInvalida("A quantidade de produtos do item não pode ser menor ou igual a zero!");
        }
        
        this.quantidade = quantidade;
    }

    public double getValorItem() {
        return valorItem;
    }
    
    public double calcularValorItem(){
        
        double valorItem;
        
        valorItem = produto.getPrecoUnitario() * getQuantidade();
        
        return valorItem;
        
    }
    
    @Override
    public String toString(){
            return getProduto() + "Quantidade: " + getQuantidade() + "\n" + "Valor total: " + getValorItem();
    }

}
