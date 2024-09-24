package Repositorys;

import Errors.ValorInvalido;
import Models.Cliente;
import java.util.ArrayList;

public class Clientes {
    
    private ArrayList<Cliente> clientes;
    private static Clientes instancia;
    
    private Clientes(){
        this.clientes = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    
    public static Clientes getInstancia(){
        if(instancia == null){
            instancia = new Clientes();
        }
        
        return instancia;
    }
    
    public void cadastrarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
    public void excluirCliente(Cliente cliente){
        if(clientes.contains(cliente)){
            clientes.remove(cliente);
        }else{
            throw new ValorInvalido("Este cliente não existe.");
        }
        
    }
    
    public void consultarClientePorNome(String nome){
        clientes.stream()
                .filter( c -> c.getNome().equals(nome))
                .forEach(c -> System.out.println(c));
    }
    
    public void visualizarClientes(){
        clientes.stream().forEach(cliente -> System.out.println(cliente));
    }

    @Override
    public String toString() {
        return "\n" + clientes;
    }
    
    
}
