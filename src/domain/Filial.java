package domain;

import java.util.ArrayList;
import java.util.List;

public class Filial {
    private String nome;
    private String endereco;
    private String cidade;
    private String cnpj;
    private String telefone;
    private String responsavel;

    private List<Cliente> listaClientes;
    private List<Carro> frota;
    private List<CarroAlugado> carrosAlugados;

    private Filial matriz;

    public Filial(String nome) {
        this.nome = nome;
        initListas();
    }
    
    public Filial(String nome, Filial matriz) {
        this.nome = nome;
        this.matriz = matriz;
        initListas();
    }

    private void initListas(){
        listaClientes = new ArrayList<Cliente>();
        frota = new ArrayList<Carro>();
        carrosAlugados = new ArrayList<CarroAlugado>();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Carro> getFrota() {
        return frota;
    }

    public void setFrota(List<Carro> frota) {
        this.frota = frota;
    }

    public List<CarroAlugado> getCarrosAlugados() {
        return carrosAlugados;
    }

    public void setCarrosAlugados(List<CarroAlugado> carrosAlugados) {
        this.carrosAlugados = carrosAlugados;
    }

    public Filial getMatriz() {
        return matriz;
    }

    public void setMatriz(Filial matriz) {
        this.matriz = matriz;
    }

    @Override
    public String toString() {
        String s = matriz == null? "": getNome()==matriz.getNome()? " * [LOJA MATRIZ]": ", Matriz = " + matriz.getNome();
        return "Nome = " + getNome() + s;
    }
   
}
