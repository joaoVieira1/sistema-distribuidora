package BuilderProducts;

import Models.enums.Marca;
import Models.Produto;

public class ProdutoBuilder implements Builder{
    
    private String descricao;
    private Marca marca;
    private double precoUnitario;
    
    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    public Produto getResult(){
        return new Produto(descricao, marca, precoUnitario);
    }
    
}
