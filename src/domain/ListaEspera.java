package domain;

public class ListaEspera {
    private Filial filial;
    private Cliente cliente;
    private Carro carro;
    
    public ListaEspera(Filial filial, Cliente cliente, Carro carro) {
        this.filial = filial;
        this.cliente = cliente;
        this.carro = carro;
    }

    public Filial getFilial() {
        return filial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    @Override
    public String toString() {
        return "\nFilial: " + 
            String.format("%-32s", filial.getNome()) +
            "\t[cliente=" + cliente.getNome() + ", carro=" + carro.getMarca() + '/' + carro.getModelo() + "]";
    }
       
}
