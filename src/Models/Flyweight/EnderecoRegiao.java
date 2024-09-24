package Models.Flyweight;

public class EnderecoRegiao {

    public String cidade;
    public String estado;

    public EnderecoRegiao(String cidade, String estado) {
        setCidade(cidade);
        setEstado(estado);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
