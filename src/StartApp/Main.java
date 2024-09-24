package StartApp;

import BuilderProducts.Diretor;
import BuilderProducts.ProdutoBuilder;
import Memento.PedidoMemento;
import Models.Cliente;
import Models.Flyweight.Endereco;
import Models.PedidoProduto;
import Models.Produto;
import Models.enums.FormaPagamento;
import Models.enums.TipoPedido;
import Repositorys.Clientes;
import Repositorys.EstoqueProdutos;
import Repositorys.Pedidos;
import Services.Pedido;


public class Main {
    
    public static void main(String[] args) {
        
        ProdutoBuilder builder = new ProdutoBuilder();
        Diretor diretor = new Diretor(builder);
        
        EstoqueProdutos<Produto> estoque = EstoqueProdutos.getInstancia();
        Clientes clientes = Clientes.getInstancia();
        Pedidos pedidos = Pedidos.getInstancia();
        
        Produto cocaLata = diretor.cocaLata();
        Produto fanta2L = diretor.fanta2L();
        
        estoque.adicionarProduto(fanta2L, 100);
        estoque.adicionarProduto(cocaLata, 50);
        
        Endereco enderecoJoao = new Endereco("Av Governador Orestes Quercia", 1301, "Lupo II", "14804300", "Araraquara", "Ap 401 bloco 24");
        Endereco enderecoMaria = new Endereco("Av Rodrigo Fernando Grilo", 1424, "Lupo I", "14606123", "Araraquara", "Ap 24");
        
        Cliente joao = new Cliente("João Pedro da Silva Vieira", "16992155796", enderecoJoao);
        Cliente maria = new Cliente("Maria Aparecida", "16992155796", enderecoMaria);
        
        clientes.cadastrarCliente(maria);
        clientes.cadastrarCliente(joao);
        
        PedidoProduto p1 = new PedidoProduto(cocaLata, 12);
        PedidoProduto p2 = new PedidoProduto(fanta2L, 6);
        PedidoProduto p3 = new PedidoProduto(cocaLata, 10);
        
        Pedido pedido1 = new Pedido(joao, FormaPagamento.DEBITO, TipoPedido.ENTREGA, estoque);
        Pedido pedido2 = new Pedido (maria, FormaPagamento.DINHEIRO, TipoPedido.RETIRADA, estoque);
        
        pedido1.adicionarProdutosAoPedido(p1);
        pedido1.adicionarProdutosAoPedido(p2);
        pedido1.adicionarProdutosAoPedido(p3);
       
        pedido1.lancarPedido(pedidos);
        pedido1.finalizarPedido();
        
        pedido2.adicionarProdutosAoPedido(p3);
        pedido2.adicionarProdutosAoPedido(p2);
        pedido2.lancarPedido(pedidos);
        pedido2.finalizarPedido();

        Pedido pedido3 = new Pedido(joao, FormaPagamento.DEBITO, TipoPedido.ENTREGA, estoque);
        PedidoMemento pm1  = pedido3.criarBackup();
        pedido3.adicionarProdutosAoPedido(p1);
        pm1.restaurar();

        
        
    }
    
    
}
