package Models;

import Errors.ValorInvalido;
import Models.Flyweight.Endereco;

public class Cliente {

    private String nome;
    private String contato;
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String nome, String contato, Endereco endereco) {
        setNome(nome);
        setContato(contato);
        setEndereco(endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isEmpty()) {
            throw new ValorInvalido("Erro, campo nome nao pode ser nulo ");
        }

        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        if (contato.isEmpty()) {
            throw new ValorInvalido("Erro, campo contato nao pode ser nulo ");
        }

        this.contato = contato;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "\n\nCliente: \n" +
                "nome: " + nome + '\n' +
                "contato: " + contato + '\n' +
                endereco;
    }
}