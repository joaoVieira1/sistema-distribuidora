package Models;

import Models.enums.Marca;
import Errors.PrecoInvalido;

public class Produto {
    
    private String descricao;
    private Marca marca;
    private double precoUnitario;

    public Produto(String descricao, Marca marca, double precoUnitario){
        setDescricao(descricao);
        setMarca(marca);
        setPrecoUnitario(precoUnitario);
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        if(precoUnitario <= 0){
            throw new PrecoInvalido("Um preço não pode ser menor ou igual a 0");
        }
        
        this.precoUnitario = precoUnitario;
        
    }
    
    @Override 
    public String toString(){
        return  "\n------------------------" + "\nProduto: \n" + "Descrição: " + getDescricao() + "\n" + "Marca: " + getMarca() + "\n" + "Valor: " + getPrecoUnitario() + "\n";
    }
    
}
