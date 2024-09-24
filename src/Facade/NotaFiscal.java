
package Facade;

import Models.Cliente;
import Models.Flyweight.Endereco;
import Models.PedidoProduto;
import Models.Produto;
import Models.enums.FormaPagamento;
import Models.enums.Marca;
import Models.enums.TipoPedido;
import Repositorys.EstoqueProdutos;
import Services.Pedido;
import Strategy.Entrega;
import Strategy.EntregaCarro;
import Strategy.EntregaEstrategia;

import java.io.File;
import java.io.FileWriter;
import java.util.stream.Collectors;

//Implementando padrao estrutural de projeto Facade, para abstrair a criação e escrita em arquivos.txt.
public class NotaFiscal {

    
    public void criarNotaFiscal(String diretorio, Pedido pedido, Entrega entrega){

        final String origem = "IFSP";

        if (diretorio == null) {
                diretorio = "./";
            }
        
        File aquivo;
        
        try {
            
            aquivo = new File(diretorio + "NF-e_" + pedido.getCliente().getNome());
            
            FileWriter escritor = new FileWriter(aquivo, true);
            
            escritor.write("===================================NOTA FISCAL " + pedido.getCliente().getNome().toUpperCase() + "===================================\n");
            escritor.write("provedor: Distribuidora IFSP\n\n\n\n\n" );

            escritor.write("===================================DADOS DO COMPRADOR===================================\n\n");
            escritor.write("nome: " + pedido.getCliente().getNome() + "\n");
            escritor.write("contato: " + pedido.getCliente().getContato() + "\n");
            escritor.write("endereço: " + pedido.getCliente().getEndereco().getRua() + " ," + pedido.getCliente().getEndereco().getNumero()
                            + " " + pedido.getCliente().getEndereco().getBairro() + " , " + pedido.getCliente().getEndereco().getRegiao().getCidade());
            
            escritor.write("\n\n===================================DADOS DA COMPRA===================================\n\n");

            escritor.write(pedido.getProdutos().stream()
                .map(produto -> produto.getProduto().getDescricao() + "------" + produto.getQuantidade() + "------" + produto.getProduto().getPrecoUnitario())
                .collect(Collectors.joining("\n")));
            
            escritor.write("\nfrete: " + pedido.getFrete());
            escritor.write("\nvalor total: " + pedido.getValorTotal());
            escritor.write("\nforma de pagamento: " + pedido.getFormaPagamento());
            


            escritor.write("\n\n===================================DADOS DA ENTREGA===================================\n\n");
            escritor.write(entrega.entrega(origem,pedido.getCliente().getEndereco().getRua() + " " + pedido.getCliente().getEndereco().getNumero()));

            escritor.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }    
    }
    
    public static void main(String[] args) { 
        
      Cliente cliente = new Cliente("Gabriel Dellatore", "16988522953", new Endereco(691,"JD Santa Angelina","14802195","Araraquara","Rua Manoel Rodrigues Jacob")); 
      EstoqueProdutos estoque = new EstoqueProdutos();
      
      Produto coca2l = new Produto("Coca-cola 2 litros",Marca.COCACOLA,20.5);
      Produto coca1_5l = new Produto("Coca-cola 1,5 litro",Marca.COCACOLA,10.5);
      
      estoque.adicionarProduto(coca2l,10);
      estoque.adicionarProduto(coca1_5l,20);
      
      PedidoProduto pp = new PedidoProduto(coca2l,2);
      PedidoProduto pp2 = new PedidoProduto(coca1_5l,1);
      
      Pedido pedido =  new Pedido(cliente, FormaPagamento.DEBITO, TipoPedido.RETIRADA, estoque);
      
      pedido.adicionarProdutosAoPedido(pp);
      pedido.adicionarProdutosAoPedido(pp2);
      pedido.calcularValorTotalPedido();

        EntregaEstrategia formaDeEntrega = new EntregaCarro();
        Entrega entrega = new Entrega(formaDeEntrega);
      
      new NotaFiscal().criarNotaFiscal("C:\\Users\\gabriel.dellatore\\Documents\\testeNF",pedido,entrega);
      
    }
}
