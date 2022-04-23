import domain.Carro;
import domain.CarroAlugado;
import domain.Cliente;
import domain.Filial;
import domain.ListaEspera;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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

        /* CRIAÇÃO DA EMPRESA...*/
        List<Filial> locadora = new ArrayList<Filial>();

        Queue<ListaEspera> listaEspera = new ArrayDeque<ListaEspera>(10);
        Stack<CarroAlugado> carrosAlugados = new Stack<>(); 

        Pensando("01) Criando e inaugurando Locadora PANGÉIA e 3 filiais...  ");
        IniciarEmpresa(locadora);

        Pensando("02) Cadastrando todos os Cliente da Matriz e das 3 filiais...  ");
        CadastrarClientes(locadora);

        Pensando("03) Comprando e cadastrando as frotas da Matriz e filiais...  ");
        CadastrarFrota(locadora);

        Pensando("04) Mostrando a situação atual da empresa: Lojas, Frotas e Clientes...");
        ListarLocadora(locadora);

        Pensando("\n05) Gerando a lista de espera para locação dos carros...  ");
        GerarListaEspera(locadora, listaEspera);

        Pensando("\n06) Mostrando as listas de espera das filiais...  ");
        System.out.println(listaEspera.toString());

        System.out.println("\n08) Atendendo a Lista de espera. Alugando carros disponíveis...  ");
        AtenderListaEspera(listaEspera, carrosAlugados);
        System.out.println("    ******* zerada a lista de espera!");

        System.out.println("\n09) Listando situação atual das frotas da Empresa...");
        ListarLocadora(locadora);


        System.out.println("\n10) Valor total das diárias dos carros alugados...");
        mostrarValorDiarias(carrosAlugados);


        Pensando("\nAguardando devolução dos carros....");
        Pensando("Ainda aguardando... choveu muito!");
        DevolverCarros(carrosAlugados);
        System.out.println("\n11) Os carros foram todos devolvidos...\n");

        Pensando("12) Organizando minha frota: TRES CARROS FORAM ROUBADOS :( retirando da lista!");
        locadora.get(0).getFrota().remove(2);
        locadora.get(0).getFrota().remove(0);
        locadora.get(2).getFrota().remove(1);

        System.out.println("11) Listando situação atual das frotas, depois do roubo:");
        ListarLocadora(locadora);




        System.out.println("\n12) Histórico dos aluguéis:");
        mostrarHistoricoAluguel(historicoAlugados);

        //Listas encadeadas......DUPLA/SIMPLES/CIRCULAR: ?




    }


    // criar a Locadora Matriz e 3 filiais...
    public static void IniciarEmpresa(List<Filial> locadora) {
        Filial matriz = new Filial("PANGEIA RENT A CAR");
        matriz.setMatriz(matriz);
        locadora.add(matriz);
        // criando 3 filiais
        locadora.add(new Filial("PANGEIA RENT A CAR - SAO PAULO", matriz));
        locadora.add( new Filial("PANGEIA RENT A CAR - BRASÍLIA", matriz));
        locadora.add( new Filial("PANGEIA RENT A CAR - RIO DE JANEIRO", matriz));
    }


    public static void CadastrarClientes(List<Filial> locadora) {
        List<Cliente> listaClientes;
        Filial filial = PesquisarFilial(locadora, "PANGEIA RENT A CAR");
        if (filial != null){
            listaClientes = filial.getListaClientes();
            listaClientes.add(new Cliente("BOB MTZ", "(42) 9.1908-6544", "Rua das Brigas, nº 13", "SUV"));
            listaClientes.add(new Cliente("PAULO MTZ", "(63) 9.1234-6544", "Marginal Tietê, nº 2121", "SEDAN"));
            listaClientes.add(new Cliente("DICK MTZ", "(62) 9.5678-0022", "Avenida Central, nº 217", "SW4"));
            listaClientes.add(new Cliente("JOHN MTZ", "(91) 9.5001-3122", "Rua 15 de Agosto, nº 1295", "SEDAN"));
            filial.setListaClientes( listaClientes);
        }
        filial = PesquisarFilial(locadora, "PANGEIA RENT A CAR - SAO PAULO");
        if (filial != null){
            listaClientes = filial.getListaClientes();
            listaClientes.add(new Cliente("CARLA SP", "(11) 9.8742-6143", "Rua 15 de Agosto, nº 1295", "SEDAN"));
            listaClientes.add(new Cliente("ANDRÉ SP", "(11) 9.9721-4222", "Residencial Maia, S/N", "CROSS"));
            listaClientes.add(new Cliente("SUELY SP", "(11) 9.5621-7661", "Edifício ÉDIFÍCIL, S/N", "SW4"));
        }
        filial = PesquisarFilial(locadora, "PANGEIA RENT A CAR - BRASÍLIA");
        if (filial != null){
            listaClientes = filial.getListaClientes();
            listaClientes.add(new Cliente("SILVANIA BSB", "(61) 9.3276-5343", "Setor Sul Bloco 2 Apt 02, S/N", "SW4"));
            listaClientes.add(new Cliente("MARTA BSB", "(61) 9.4772-6811", "SQN2 bloco 1 Ap 1908", "CROSS"));
            listaClientes.add(new Cliente("DOUGLAS BSB", "(61) 9.9131-9911", "SHN Quadra 02 Bloco 16 Apt 16", "HB20"));
        }
        filial = PesquisarFilial(locadora, "PANGEIA RENT A CAR - RIO DE JANEIRO");
        if (filial != null){
            listaClientes = filial.getListaClientes();
            listaClientes.add(new Cliente("MATEUS RJ", "(21) 9.3199-4218", "Corcovado, nº 1A", "AX30"));
            listaClientes.add(new Cliente("MARCOS RJ", "(21) 9.4137-9652", "Leblon, nº 122", "HB20"));
            listaClientes.add(new Cliente("LUCAS RJ", "(21) 9.6523-4378", "Copacabana, S/N", "SEDAN"));
        }
    }

    public static void CadastrarFrota(List<Filial> locadora) {
        List<Carro> frota;
        Filial filial = PesquisarFilial(locadora, "PANGEIA RENT A CAR");
        if (filial != null){
            frota = filial.getFrota();
            frota.add(new Carro("BTC-6591","FIAT", "CROSS", 35.00, true));
            frota.add(new Carro("DKN-3333","WOLKS", "HB20", 127.00, true));
            frota.add(new Carro("AAZ-1234","ALFA", "SUV", 371.00, true));
        }
        filial = PesquisarFilial(locadora, "PANGEIA RENT A CAR - SAO PAULO");
        if (filial != null){
            frota = filial.getFrota();
            frota.add(new Carro("BTC-6591","FIAT", "CROSS", 125.00, true));
            frota.add(new Carro("DKN-3333","WOLKS", "HB20", 980.00, true));
            frota.add(new Carro("AAZ-1234","ALFA", "SUV", 211.00, true));
            frota.add(new Carro("PRW-8970","CHERRY", "HATCH", 137.00, true));
        }
        filial = PesquisarFilial(locadora, "PANGEIA RENT A CAR - BRASÍLIA");
        if (filial != null){
            frota = filial.getFrota();
            frota.add(new Carro("AMK-1358","TOYOTA", "SW4", 183.00, true));
            frota.add(new Carro("AQD-4798","FIAT", "SEDAN", 95.00, true));
        }
            frota = filial.getFrota();
        filial = PesquisarFilial(locadora, "PANGEIA RENT A CAR - RIO DE JANEIRO");
        if (filial != null){
            frota = filial.getFrota();
            frota.add(new Carro("BBM-1358","WOLKS", "SUV", 312.00, true));
            frota.add(new Carro("CCT-6328","TOYOTA", "AX30", 171.00, true));
            frota.add(new Carro("DDO-5638","TESLA", "SW4", 211.00, true));
            frota.add(new Carro("EEQ-2318","TIGUAN", "HATCH", 96.00, true));
        }
    }

    public static void GerarListaEspera(List<Filial> locadora, Queue<ListaEspera> listaEspera) {
        listaEspera.add(new ListaEspera(locadora.get(0), locadora.get(0).getListaClientes().get(0), locadora.get(0).getFrota().get(1)));
        listaEspera.add(new ListaEspera(locadora.get(0), locadora.get(0).getListaClientes().get(2), locadora.get(0).getFrota().get(0)));

        listaEspera.add(new ListaEspera(locadora.get(1), locadora.get(1).getListaClientes().get(2), locadora.get(1).getFrota().get(1)));
        listaEspera.add(new ListaEspera(locadora.get(1), locadora.get(1).getListaClientes().get(1), locadora.get(1).getFrota().get(0)));
        listaEspera.add(new ListaEspera(locadora.get(1), locadora.get(1).getListaClientes().get(0), locadora.get(1).getFrota().get(2)));

        listaEspera.add(new ListaEspera(locadora.get(2), locadora.get(2).getListaClientes().get(0), locadora.get(2).getFrota().get(1)));
        listaEspera.add(new ListaEspera(locadora.get(2), locadora.get(2).getListaClientes().get(1), locadora.get(2).getFrota().get(0)));

        listaEspera.add(new ListaEspera(locadora.get(3), locadora.get(3).getListaClientes().get(0), locadora.get(3).getFrota().get(0)));
        listaEspera.add(new ListaEspera(locadora.get(3), locadora.get(3).getListaClientes().get(1), locadora.get(3).getFrota().get(1)));
    }

    public static void AtenderListaEspera(Queue<ListaEspera> listaEspera, Stack<CarroAlugado> carrosAlugados) {
        while ( !listaEspera.isEmpty()) {
            Pensando("Alugando o carro: " + 
                                listaEspera.element().getCarro().getMarca() + ", " + 
                                listaEspera.element().getCarro().getModelo() + ", " + 
                                listaEspera.element().getCarro().getPlaca() + " para: " + 
                                listaEspera.element().getCliente().getNome() + "    ");
            alugarCarro(listaEspera.remove(), carrosAlugados);
        }
    }

    public static void mostrarValorDiarias(Stack<CarroAlugado> carrosAlugados) {
        int diarias = 0;
        double valorTotal = 0;
        for (CarroAlugado carroAlugado : carrosAlugados ) {
            if (!carroAlugado.getListaEspera().getCarro().isDisponivel()) {
                diarias = (int)((System.currentTimeMillis() - carroAlugado.getDataEmprestimo() ) / 86400000 );
                valorTotal += carroAlugado.getListaEspera().getCarro().getValorDiaria() * diarias;
                String s = String.format("%-88s", 
                    "  > Carro: " +
                        carroAlugado.getListaEspera().getCarro().getMarca() + "/" +
                        carroAlugado.getListaEspera().getCarro().getModelo() + "/" +
                        carroAlugado.getListaEspera().getCarro().getPlaca() + 
                        ", Cliente: " +
                        carroAlugado.getListaEspera().getCliente().getNome() +
                        "  Data aluguel: " + 
                        new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(carroAlugado.getDataEmprestimo()));
                System.out.printf("%s \t(Diárias: %d x R$ %8s = R$ %9s)\n",
                        s,
                        diarias,
                        new DecimalFormat("#,###.00").format(carroAlugado.getListaEspera().getCarro().getValorDiaria()),
                        new DecimalFormat("##,###.00").format(diarias * carroAlugado.getListaEspera().getCarro().getValorDiaria()));
            }
        }
        System.out.println("-".repeat(140) );
        System.out.printf(" ".repeat(115) + "TOTAL:  R$ %10s \n", new DecimalFormat("###,###.00").format(valorTotal));
    }

    public static void DevolverCarros(Stack<CarroAlugado> carrosAlugados) {
        while ( !carrosAlugados.isEmpty()) {
            Pensando( "DEVOLVENDO: "  + 
                carrosAlugados.peek().getListaEspera().getCliente().getNome() + ", carro " +
                carrosAlugados.peek().getListaEspera().getCarro().getModelo() + ", " + 
                carrosAlugados.peek().getListaEspera().getCarro().getPlaca() + "  " );
                devolverCarro(carrosAlugados, carrosAlugados.peek().getListaEspera().getCarro());
        }
    }

    public static void mostrarHistoricoAluguel(Stack<CarroAlugado> carrosAlugados) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("                HISTÓRICO DE ALUGUEL");
        System.out.println("-------------------------------------------------------------");
        historicoAlugados.stream()
            .forEach(c -> System.out.print(c.toString()));
    }

    public static Filial PesquisarFilial(List<Filial> locadora, String nome) {
        for (Filial f : locadora) {
            if (f.getNome()==nome)
                return f;
        }
        return null;
    }

    // listar as lojas da locadora...
    public static void ListarLocadora(List<Filial> locadora) {
       String s = "\n" +
            " _\n" +
            "|_)   _.  ._    _    _´  o   _. \n" +
            "|    (_|  | |  (_|  (/_  |  (_|  RENT A CAR®\n" +
            "─────────────── _|" + "─".repeat(102) + "\n";
        for (Filial filial : locadora) {
            s += "\n" + filial.toString() +"\n" + "¨".repeat(120);
            for (Carro carro :  ordenarFrotasPorValorDiaria(filial.getFrota())) {
                s += carro.toString();
            }
            for (Cliente cliente : filial.getListaClientes()) {
                s += cliente.toString();
            }
        }
        System.out.println(s);
    }

    //-----------

    public static long dataHora(){
        long fator = (long)(100000000 + Math.random() * (500000000 - 100000000)) ; //POG!
        return System.currentTimeMillis() - fator;
    }

    public static void Pensando(String msg) {
        try {
            System.out.printf(String.format("%-90s", msg));
            for (int i = 0; i < 10; i++) {
                Thread.sleep(20);
                System.out.print("»");
            }
            System.out.print("  =>  feito!\n");
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

    public static void listarFrotaOrdenada(List<Carro> frota) {  /** */
        ordenarFrotasPorValorDiaria(frota).stream()
        .forEach(c -> System.out.print(c.toString()));
        System.out.println();
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
