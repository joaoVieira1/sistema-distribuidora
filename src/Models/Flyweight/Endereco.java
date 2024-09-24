package Models.Flyweight;

import Errors.ValorInvalido;

//implementando Flyweight para gravar valores comuns a todos os enderecos
public class Endereco {
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cep;
    private EnderecoRegiao regiao;
    private String complemento;
    private String rua;

    public Endereco(){
        this(null,null,null,null,null,null,null);
    }

    public Endereco(Integer numero, String bairro, String cep, String rua){
        this(null,numero,bairro,cep,null,null,rua);
    }

    public Endereco(Integer numero, String bairro, String cep, String complemento, String rua){
        this(null,numero,bairro,cep,null,complemento,rua);
    }


    public Endereco(String logradouro, Integer numero, String bairro, String cep, String complemento, String rua){
        this(logradouro,numero,bairro,cep,null,complemento,rua);
    }
    
    public Endereco(String logradouro, Integer numero, String bairro, String cep, EnderecoRegiao enderecoRegiao,String complemento, String rua) {
        setLogradouro(logradouro);
        setNumero(numero);
        setBairro(bairro);
        setCep(cep);
        this.regiao = regiao;
        setComplemento(complemento);
        setRua(rua);
    }


    public EnderecoRegiao getRegiao() {
        return regiao;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }


    public String getComplemento() {
        return complemento;
    }

    public String getRua() {
        return rua;
    }  
    
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(Integer numero) {
        if (numero < 0) {
            throw new ValorInvalido("Erro, campo numero nao pode ser negativo ");
        } else if (numero == 0) {
            throw new ValorInvalido("Erro, campo numero nao pode ser igual a 0");
        }

        this.numero = numero;
    }

    public void setBairro(String bairro) {
        if (bairro.isEmpty()) {
            throw new ValorInvalido("Erro, campo bairro nao pode ser nulo ");
        }

        this.bairro = bairro;
    }

    public void setCep(String cep) {
        String regex = "^\\d{5}-?\\d{3}$";
        if (cep.matches(regex)) {
            throw new ValorInvalido("Erro, campo cep nao é valido ");
        }
        this.cep = cep;
    }


    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setRua(String rua) {
        if (rua == null) {
            throw new ValorInvalido("Erro, campo rua não é valido");
        }
        
        this.rua = rua;
    }

    public void setRegiao(EnderecoRegiao regiao) {
        if (regiao == null) {
            throw new ValorInvalido("Erro, campo regiao não é valido");
        }
        this.regiao = regiao;
    }

    @Override
    public String toString() {
        return "Endereco{" + "logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + regiao + ", complemento=" + complemento + ", rua=" + rua + '}';
    }
    
    
}

