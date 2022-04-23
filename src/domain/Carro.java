package domain;

public class Carro implements Comparable<Carro> {
    private String placa;
    private String marca;
    private String modelo;
    private double valorDiaria;
    private boolean disponivel;

    public Carro(String placa, String marca, String modelo, double valorDiaria, boolean disponivel) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        String seDisponivel = disponivel ? "SIM" : "NÃO*";
        return "\n\t> Carro{" +
                "placa='" + placa + '\'' +
                ",\tmarca='" + marca + '\'' +
                ",\tmodelo='" + modelo + '\'' +
                ",\tvalorDiaria= R$ " + String.format("%6.2f", valorDiaria) +
                ",\tdisponivel=" + seDisponivel +
                '}';
    }

    @Override
    public int compareTo(Carro o) {
        return Double.compare(this.valorDiaria, o.valorDiaria);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
