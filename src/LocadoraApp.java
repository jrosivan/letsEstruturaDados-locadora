import domain.Carro;
import domain.CarroAlugado;
import domain.Cliente;
import domain.ListaEspera;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class LocadoraApp  {

    public static Stack<CarroAlugado> historicoAlugados = new Stack<CarroAlugado>();

    public static void main(String[] args)  {

        List<Carro> frota =  new ArrayList<Carro>();
        List<Cliente> clientes =  new ArrayList<Cliente>();
        Queue<ListaEspera> listaEspera = new ArrayDeque<ListaEspera>(10);
        Stack<CarroAlugado> carrosAlugados = new Stack<>(); 


        System.out.println("┌".concat("─".repeat(50)).concat("┐"));
        System.out.println("│                PANGEIA RENT A CAR                │");
        System.out.println("└".concat("─".repeat(50)).concat("┘"));

        System.out.println("1) Comprando meus carros...");

        inserirListaFrota( frota, new Carro("BTC-6591","FIAT", "CROSS", 35.00, true));
        inserirListaFrota( frota, new Carro("DKN-3333","WOLKS", "HB20", 120.00, true));
        inserirListaFrota( frota, new Carro("AAZ-1234","ALFA", "SUV", 350.00, true));
        inserirListaFrota( frota, new Carro("PRW-8970","CHERRY", "HATCH", 435.00, true));
        inserirListaFrota( frota, new Carro("AMK-1358","TOYOTA", "SW4", 275.00, true));
        inserirListaFrota( frota, new Carro("AQD-4798","FIAT", "SEDAN", 217.00, true));
        inserirListaFrota( frota, new Carro("BBM-1358","WOLKS", "SUV", 312.00, true));
        inserirListaFrota( frota, new Carro("CCT-6328","TOYOTA", "AX30", 123.00, true));
        inserirListaFrota( frota, new Carro("DDO-5638","TESLA", "SW4", 271.00, true));
        inserirListaFrota( frota, new Carro("EEQ-2318","TIGUAN", "HATCH", 83.00, true));

        Pensando("comprei " + frota.size() + " carros");

        System.out.println("2) Preciso organizar por valor de aluguel e listar, momento...");
        listarFrotaOrdenada(frota);
        Pensando("");


        System.out.println("3) Cadastrando todos os meus Cliente (todos os 3):");
        inserirListaCliente(clientes, new Cliente("BOB", "(61) 9.1234-6544", "Rua das Brigas, nº 13", "SUV"));
        inserirListaCliente(clientes, new Cliente("DICK", "(61) 9.5678-0022", "Avenida Central, nº 217", "SW4"));
        inserirListaCliente(clientes, new Cliente("JOHN", "(61) 9.5001-3122", "Rua 15 de Agosto, nº 1295", "SEDAN"));
        Pensando("clientes cadastrados");

        System.out.println("5) Listando meus "  + clientes.size() + " clientes:");
        clientes.stream().forEach(c -> System.out.print(c.toString()));
        System.out.println();
        Pensando("este são os meus clientes");


        System.out.println("6) Cadastrando minha lista de espera:");
        inserirListaEspera(listaEspera, clientes.get(2), frota.get(5) );
        inserirListaEspera(listaEspera, clientes.get(0), frota.get(7) );
        inserirListaEspera(listaEspera, clientes.get(1), frota.get(3) );
        Pensando("Chegaram " + 
                 clientes.get(2).getNome() + ", " + 
                 clientes.get(0).getNome() + ", " + 
                 clientes.get(1).getNome() + ". ");

        System.out.println("7) Mostrando minha lista de espera (cliente por ordem de chegada e preferência do carro):");
        System.out.println(listaEspera.toString());
        System.out.println("");


        System.out.println("8) Atendendo a Lista de espera. Alugando carros disponíveis:");
        while ( !listaEspera.isEmpty()) {
            System.out.println("Alugando o carro: " + 
                                listaEspera.element().getCarro().getMarca() + ", " + 
                                listaEspera.element().getCarro().getModelo() + ", " + 
                                listaEspera.element().getCarro().getPlaca() + " para: " + 
                                listaEspera.element().getCliente().getNome());
            alugarCarro(listaEspera.remove(), carrosAlugados);
        }
        Pensando("zerada a lista de espera");


        System.out.println("9) Listando situação atual da minha frota:");
        listarFrotaOrdenada(frota);
        Pensando("");


        Pensando("aguardando devolução");
        Pensando("ainda aguardando... choveu muito!");
        while ( !carrosAlugados.isEmpty()) {
            System.out.print( "DEVOLVENDO: "  + 
                carrosAlugados.peek().getListaEspera().getCliente().getNome() + ", carro " +
                carrosAlugados.peek().getListaEspera().getCarro().getModelo() + ", " + 
                carrosAlugados.peek().getListaEspera().getCarro().getPlaca() + "  " );
                devolverCarro(carrosAlugados, carrosAlugados.peek().getListaEspera().getCarro());
            Pensando(" carro devolvido:");
        }
        System.out.println("10) Os carros foram todos devolvidos:\n");


        System.out.println("11) Organizando minha frota: DOIS CARROS FORAM ROUBADOS :(  - retirando da lista!");
        Pensando("mas fiz BO!");
        frota.remove(3);
        frota.remove(7);
        System.out.println("11) Listando situação atual da minha frota, depois do roubo:");
        listarFrotaOrdenada(frota);
        Pensando("");


        System.out.println("-------------------------------------------------------------");
        System.out.println("     HISTÓRICO DE ALUGUEL");
        System.out.println("-------------------------------------------------------------");
        historicoAlugados.stream()
        .forEach(c -> System.out.print(c.toString()));
        System.out.println();


        //Listas encadeadas......DUPLA/SIMPLES/CIRCULAR




    }

    public static long dataHora(){
        long fator = (long)(100000000 + Math.random() * (500000000 - 100000000)) ; //POG!
        return System.currentTimeMillis() - fator;
    }

    public static void Pensando(String msg) {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.print("»");
            }
            System.out.printf("  %s  =>  feito!\n\n", msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<Carro> ordenarFrotasPorValorDiaria(List<Carro> frota) {
        List<Carro> sortedList = frota.stream()
            .sorted(Comparator.comparingDouble(Carro::getValorDiaria))
            .collect(Collectors.toList());
        return sortedList;

    }

    public static void listarFrotaOrdenada(List<Carro> frota) {
        ordenarFrotasPorValorDiaria(frota).stream()
        .forEach(c -> System.out.print(c.toString()));
        System.out.println();
    }

    public static void inserirListaFrota( List<Carro> frota, Carro carro){
        frota.add(carro);
    }

    public static void inserirListaCliente(List<Cliente> lista, Cliente cliente){
        lista.add(cliente);
    }

    public static void inserirListaEspera(Queue<ListaEspera> listaEspera, Cliente cliente, Carro carro){
        listaEspera.add(new ListaEspera(cliente, carro));
    }

    public static void alugarCarro(ListaEspera espera, Stack<CarroAlugado> carrosAlugados) {
        carrosAlugados.push(new CarroAlugado(dataHora(),  espera));
        setarDisponibilidadeCarro(espera.getCarro(), false);
    }

    public static void devolverCarro( Stack<CarroAlugado> alugados, Carro carro ){
        for (CarroAlugado carroAlugado: alugados) {
            if (carroAlugado.getListaEspera().getCarro() == carro ){
                historicoAlugados.add(new CarroAlugado(carroAlugado.getDataEmprestimo(), carroAlugado.getListaEspera()));

                long dataDevolvido = carroAlugado.getDataEmprestimo() + (long)(100000000 + Math.random() * (500000000 - 100000000)) ; //POG-mudar datas!
                historicoAlugados.peek().setDataDevolvido(dataDevolvido);

                alugados.remove(carroAlugado);
                setarDisponibilidadeCarro(carro, true);
                return;
            }
        }
    }

    public static void setarDisponibilidadeCarro(Carro carro, boolean flag) {
        carro.setDisponivel(flag);
    }

}
