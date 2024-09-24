package BuilderProducts;

import Models.enums.Marca;

public interface Builder {
    
    void setDescricao(String descricao);
    void setMarca(Marca marca);
    void setPrecoUnitario(Double precoUnitario);
   
}
