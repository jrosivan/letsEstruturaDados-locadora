package domain;

import java.text.SimpleDateFormat;

public class CarroAlugado {
    private long dataEmprestimo;
    private long dataDevolvido;
    private ListaEspera listaEspera;
    
    public CarroAlugado(long dataEmprestimo, ListaEspera listaEspera) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolvido = 0;
        this.listaEspera = listaEspera;
    }

    public long getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(long dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public long getDataDevolvido() {
        return dataDevolvido;
    }

    public void setDataDevolvido(long dataDevolvido) {
        this.dataDevolvido = dataDevolvido;
    }

    public ListaEspera getListaEspera() {
        return listaEspera;
    }

    public void setListaEspera(ListaEspera listaEspera) {
        this.listaEspera = listaEspera;
    }

    @Override
    public String toString() {
        String s1, s2 = "";
        s1 = "\n" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format( dataEmprestimo )  +
         ": Carro: " + listaEspera.getCarro().getMarca() + ", " + listaEspera.getCarro().getModelo() +
             ", " + listaEspera.getCarro().getPlaca() + ", foi EMPRESTADO por: " + listaEspera.getCliente().getNome(); 
        if(dataDevolvido != 0){
            s2 = "\n" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataDevolvido) + 
            ": Carro: " + listaEspera.getCarro().getMarca() + ", " + listaEspera.getCarro().getModelo() +
                ", " + listaEspera.getCarro().getPlaca() + ", foi DEVOLVIDO por: " + listaEspera.getCliente().getNome();
            } 
        return s1+s2;
    }
        
    
}
