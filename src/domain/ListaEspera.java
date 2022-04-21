package domain;

public class ListaEspera {
    private Cliente cliente;
    private Carro carro;
    
    public ListaEspera(Cliente cliente, Carro carro) {
        this.cliente = cliente;
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    @Override
    public String toString() {
        return "\n[cliente=" + cliente.getNome() + ", carro=" + carro.getMarca() + '/' + carro.getModelo() + "]";
    }
       
}
