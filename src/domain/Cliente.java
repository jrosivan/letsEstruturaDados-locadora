package domain;

public class Cliente {
    private String nome;
    private String telefone;
    private String endereco;
    private String carroDesejado;
    
    public Cliente(String nome, String telefone, String endereco, String carroDesejado) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.carroDesejado = carroDesejado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCarroDesejado() {
        return carroDesejado;
    }

    @Override
    public String toString() {
        return "\nCliente [Nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + "]";
    }

    

}


