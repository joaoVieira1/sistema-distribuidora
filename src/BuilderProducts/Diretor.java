package BuilderProducts;

import Models.enums.Marca;
import Models.Produto;

public class Diretor {
    
    ProdutoBuilder builder;
    
    public Diretor(ProdutoBuilder builder){
        this.builder = builder;
    }
    
    public Produto cocaLata(){
        builder.setDescricao("Coca-Cola Original 350ml Lata");
        builder.setMarca(Marca.COCACOLA);
        builder.setPrecoUnitario(3.89);
        return builder.getResult();
    }
    
    public Produto fantaLata(){
        builder.setDescricao("Fanta Laranja Original 350ml Lata");
        builder.setMarca(Marca.FANTA);
        builder.setPrecoUnitario(3.00);
        return builder.getResult();
    }
    
    public Produto guaranaLata(){
        builder.setDescricao("Guarana Original 350ml Lata");
        builder.setMarca(Marca.GUARANA);
        builder.setPrecoUnitario(3.50);
        return builder.getResult();
    }
    
    public Produto pepsiLata(){
        builder.setDescricao("Pepsi Original 350ml Lata");
        builder.setMarca(Marca.PEPSI);
        builder.setPrecoUnitario(3.70);
        return builder.getResult();
    }
    
    public Produto spriteLata(){
        builder.setDescricao("Sprite Original 350ml Lata");
        builder.setMarca(Marca.SPRITE);
        builder.setPrecoUnitario(3.20);
        return builder.getResult();
    }
    
    public Produto coca2L(){
        builder.setDescricao("Coca-Cola Original 2L Garrafa");
        builder.setMarca(Marca.COCACOLA);
        builder.setPrecoUnitario(8.90);
        return builder.getResult();
    }
    
    public Produto fanta2L(){
        builder.setDescricao("Fanta Original 2L Garrafa");
        builder.setMarca(Marca.FANTA);
        builder.setPrecoUnitario(8.00);
        return builder.getResult();
    }
    
    public Produto guarana2L(){
        builder.setDescricao("Guarana Original 2L Garrafa");
        builder.setMarca(Marca.GUARANA);
        builder.setPrecoUnitario(8.50);
        return builder.getResult();
    }
    
    public Produto pepsi2L(){
        builder.setDescricao("Pepsi Original 2L Garrafa");
        builder.setMarca(Marca.PEPSI);
        builder.setPrecoUnitario(8.70);
        return builder.getResult();
    }
    
    public Produto sprite2L(){
        builder.setDescricao("Sprite Original 2L Garrafa");
        builder.setMarca(Marca.SPRITE);
        builder.setPrecoUnitario(8.00);
        return builder.getResult();
    }
    
    public Produto aguaBonafontGarrafa(){
        builder.setDescricao("Agua Bonafont Original 1.5L Garrafa");
        builder.setMarca(Marca.BONAFONT);
        builder.setPrecoUnitario(7.00);
        return builder.getResult();
    }
    
    public Produto aguaBonafontGalao(){
        builder.setDescricao("Agua Bonafont Original 3L Galão");
        builder.setMarca(Marca.BONAFONT);
        builder.setPrecoUnitario(15.0);
        return builder.getResult();
    }
    
    public Produto aguaCrystalGarrafa(){
        builder.setDescricao("Agua Crystal Original 1.5L Garrafa");
        builder.setMarca(Marca.CRYSTAL);
        builder.setPrecoUnitario(7.50);
        return builder.getResult();
    }
    
    public Produto aguaCrystalGalao(){
        builder.setDescricao("Agua Crystal Original 3L Galão");
        builder.setMarca(Marca.CRYSTAL);
        builder.setPrecoUnitario(15.50);
        return builder.getResult();
    }
    
}
