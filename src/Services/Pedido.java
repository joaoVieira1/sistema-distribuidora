package Services;

import Errors.FaltaEmEstoque;
import Errors.ValorInvalido;
import Memento.PedidoMemento;
import Models.Cliente;
import Models.PedidoProduto;
import Models.Produto;
import Models.enums.FormaPagamento;
import Models.enums.Status;
import Models.enums.TipoPedido;
import Repositorys.EstoqueProdutos;
import Repositorys.Pedidos;

import java.util.ArrayList;

public class Pedido {
    
    private Cliente cliente;
    private Status status;
    private FormaPagamento formaPagamento;
    private TipoPedido tipoPedido;
    private double valorTotal = 0.0;
    private final double frete = 7;
    private ArrayList<PedidoProduto> produtos;
    private EstoqueProdutos<Produto> estoqueProdutos;
    
    public Pedido(Cliente cliente, FormaPagamento formaPagamento, TipoPedido tipoPedido, EstoqueProdutos estoqueProdutos){
        this.cliente = cliente;
        this.status = Status.EM_ANDAMENTO;
        this.formaPagamento = formaPagamento;
        this.tipoPedido = tipoPedido;
        produtos = new ArrayList<>();
        this.estoqueProdutos = estoqueProdutos;
        if(this.tipoPedido.equals(TipoPedido.ENTREGA)){
            this.valorTotal += frete;
        }
    }

    public void adicionarProdutosAoPedido(PedidoProduto pedidoProduto){
        
        if(estoqueProdutos.quantidade(pedidoProduto.getProduto()) >= pedidoProduto.getQuantidade()){
            
            estoqueProdutos.remover(pedidoProduto.getProduto(), pedidoProduto.getQuantidade());
            this.produtos.add(pedidoProduto);
        }else{
            throw new FaltaEmEstoque("Produto em falta no estoque.");
        }
        
    }
    
    public void removerProdutosDoPedido(PedidoProduto pedidoProduto){
        
        if(produtos.contains(pedidoProduto)){
            
            estoqueProdutos.adicionarProduto(pedidoProduto.getProduto(), pedidoProduto.getQuantidade());
            produtos.remove(pedidoProduto);
        }else{
            throw new ValorInvalido("Produto não encontrado");
        }
        
    }
    
    public void calcularValorTotalPedido(){
        produtos.stream().forEach(produto -> this.valorTotal += produto.getValorItem());   
        this.valorTotal += getFrete();
    }
    
    public void lancarPedido(Pedidos pedidos){
        pedidos.cadastrarPedido(this);
        calcularValorTotalPedido();
    }
    
    public void finalizarPedido(){
        this.status = Status.FINALIZADO;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public Status getStatusPedido(){
        return this.status;
    }
    
    public double getValorTotal(){
        return valorTotal;
    }

    public ArrayList<PedidoProduto> getProdutos() {
        return produtos;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public double getFrete() {
        return frete;
    }

    public EstoqueProdutos<Produto> getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void setProdutos(ArrayList<PedidoProduto> produtos) {
        this.produtos = produtos;
    }

    public PedidoMemento criarBackup(){
        return new PedidoMemento(this);
    }

    @Override
    public String toString() {
        //return "========PEDIDO========" + cliente + "\n------------------------\n" + "status: " + status + "\n" + "forma de pagamento: " + formaPagamento + "\n" + "tipo do pedido: " + tipoPedido + "\n" + "valor total do pedido: " + valorTotal + "\n" + "frete do pedido: " + frete + "\n" + "------------------------\n" + produtos + "\n------------------------\n";
        return "" + produtos;
    }
    
    
    
    
    
    
    
  
 
}
