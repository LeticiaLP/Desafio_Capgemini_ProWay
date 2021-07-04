package anuncio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    String nomeAnuncio;
    String nomeCliente;
    String dataInicio;
    String dataTermino;
    float valorDia;
    int indice;
    int anoI;
    int mesI;
    int diaI;
    int anoT;
    int mesT;
    int diaT;
    LocalDate dataI;
    LocalDate dataT;
    LocalDate periodoInicial;
    LocalDate periodoFinal;
    Object nome;
    String relatorio;
    String [] A = new String[6];

    Scanner in = new Scanner(System.in);
    Calculadora calc = new Calculadora();
    ArrayList<Object> lista = new ArrayList<Object>();
    DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String getNomeAnuncio() {
        return nomeAnuncio;
    }
    public void setNomeAnuncio(String nomeAnuncio) {
        this.nomeAnuncio = nomeAnuncio;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }
    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public float getValorDia() {
        return valorDia;
    }
    public void setValorDia(float valorDia) {
        this.valorDia = valorDia;
    }

    public LocalDate getDataI() {
        return dataI;
    }
    public void setDataI(LocalDate dataI) {
        this.dataI = dataI;
    }

    public LocalDate getDataT() {
        return dataT;
    }
    public void setDataT(LocalDate dataT) {
        this.dataT = dataT;
    }

    public LocalDate getPeriodoInicial() {
        return periodoInicial;
    }
    public void setPeriodoInicial(LocalDate periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public LocalDate getPeriodoFinal() {
        return periodoFinal;
    }
    public void setPeriodoFinal(LocalDate periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public Object getNome() {
        return nome;
    }
    public void setNome(Object nome) {
        this.nome = nome;
    }
        //Formulário para inserir os dados do cliente usando o teclado
    public void inserirDados() {

        System.out.print("\nNome do Anúncio: ");
        nomeAnuncio = in.nextLine();
        System.out.print("Nome do Cliente: ");
        nomeCliente = in.nextLine();
        System.out.println("Data de Início do Anúncio");
        System.out.print("Dia: ");
        diaI = in.nextInt();
        System.out.print("Mês: ");
        mesI = in.nextInt();
        System.out.print("Ano: ");
        anoI = in.nextInt();
        System.out.println("Data de Término do Anúncio");
        System.out.print("Dia: ");
        diaT = in.nextInt();
        System.out.print("Mês: ");
        mesT = in.nextInt();
        System.out.print("Ano: ");
        anoT = in.nextInt();
        System.out.print("Valor Diário Investido no Anúncio: R$ ");
        valorDia = in.nextFloat(); in.nextLine();

        dataI = LocalDate.of(anoI, mesI, diaI);
        dataT = LocalDate.of(anoT, mesT,diaT);

        dataInicio = formatar.format(dataI);
        dataTermino = formatar.format(dataT);
    }
        //Formulário para inserir o intervalo de tempo na busca por período usando o teclado
    public void inserirIntervaloTempo() {

        System.out.println("\nPeríodo inicial da busca");
        System.out.print("Dia: ");
        diaI = in.nextInt();
        System.out.print("Mês: ");
        mesI = in.nextInt();
        System.out.print("Ano: ");
        anoI = in.nextInt();
        System.out.println("\nPeríodo final da busca");
        System.out.print("Dia: ");
        diaT = in.nextInt();
        System.out.print("Mês: ");
        mesT = in.nextInt();
        System.out.print("Ano: ");
        anoT = in.nextInt();

        periodoInicial = LocalDate.of(anoI, mesI, diaI);
        periodoFinal = LocalDate.of(anoT, mesT, diaT);
    }
        //Cálculo do valor total do anúncio a partir do valor diário
    public float calcularValorTotal() {
        long diasAnuncio;

        diasAnuncio = ChronoUnit.DAYS.between(dataI, dataT);
        calc.setValorTotal(valorDia * diasAnuncio);
        return calc.getValorTotal();
    }
        //Cadastro de anúncios (os cadastros são inseridos numa lista contida na memória)
    public ArrayList<Object> cadastrarAnuncio() {

        List<Object> dados = new ArrayList<>();

        dados.add(nomeAnuncio);
        dados.add(nomeCliente);
        dados.add(dataInicio);
        dados.add(dataTermino);
        dados.add(valorDia);
        dados.add(calcularValorTotal());

        lista.add(dados);

        return lista;
    }
        //Busca todos os anúncios armazenados na memória
    public void buscarTodosAnuncios() {

        relatorio = lista.get(indice).toString().replaceAll("\\[", "");
        relatorio = relatorio.replaceAll("\\]", "");

        A = relatorio.split(", ");

        nomeAnuncio = A[0];
        nomeCliente = A[1];
        dataInicio = A[2];
        dataTermino = A[3];
        valorDia = Float.parseFloat(A[4]);
        calc.setValorTotal(Float.parseFloat(A[5]));
}
        //Busca os anúncios por clientes
    public void buscarCliente() {

        List<Object> listaVazia1 = new ArrayList<>();

        for (Object cliente: lista) {

            relatorio = cliente.toString().replaceAll("\\[", "");
            relatorio = relatorio.replaceAll("\\]", "");

            A = relatorio.split(", ");

            List<Object> buscaCliente = Arrays.asList(A);

            if (buscaCliente.contains(nome)) {
                nomeAnuncio = A[0];
                nomeCliente = A[1];
                dataInicio = A[2];
                dataTermino = A[3];
                valorDia = Float.parseFloat(A[4]);
                calc.setValorTotal(Float.parseFloat(A[5]));

                gerarRelatorioAnuncios();

                listaVazia1.add(buscaCliente);
            }
        }

        if (listaVazia1.isEmpty()) {
            System.out.println("Cliente não cadastrado.");
        }
    }
        //Busca os anúncios por intervalo de tempo
    public void buscarIntervaloTempo() {
        String anuncioLista;
        String novoFormatoI;
        String novoFormatoT;
        LocalDate dataAnuncio;

        List<Object> listaVazia2 = new ArrayList<>();

        for (Object lista: lista) {
            A = new String[6];

            List<LocalDate> datas = new ArrayList<>();

            anuncioLista = lista.toString().replaceAll("\\[", "");
            anuncioLista = anuncioLista.replaceAll("\\]", "");
            A = anuncioLista.split(", ");

            novoFormatoI = A[2];
            String [] C = new String[3];
            C = novoFormatoI.split("/");
            novoFormatoI = String.format("%s-%s-%s", C[2], C[1], C[0]);

            novoFormatoT = A[3];
            String [] D = new String[3];
            D = novoFormatoT.split("/");
            novoFormatoT = String.format("%s-%s-%s", D[2], D[1], D[0]);

            dataI = LocalDate.parse(novoFormatoI);
            dataT = LocalDate.parse(novoFormatoT);

            dataAnuncio = dataI;

            for (long d = 0; d < ChronoUnit.DAYS.between(dataI, dataT); d++) {

                datas.add(dataAnuncio);

                dataAnuncio = dataAnuncio.plusDays(1);
            }

            label:
            for (LocalDate dataAnuncio2 : datas) {

                LocalDate periodoInicial1 = periodoInicial;

                for (long d = 0; d <= ChronoUnit.DAYS.between(periodoInicial, periodoFinal); d++) {

                    if (dataAnuncio2.isEqual(periodoInicial1)) {
                        nomeAnuncio = A[0];
                        nomeCliente = A[1];
                        dataInicio = A[2];
                        dataTermino = A[3];
                        valorDia = Float.parseFloat(A[4]);
                        calc.setValorTotal(Float.parseFloat(A[5]));

                        gerarRelatorioAnuncios();

                        listaVazia2.add(A);

                        break label;
                    }

                    periodoInicial1 = periodoInicial1.plusDays(1);
                }
            }
        }

        if (listaVazia2.isEmpty()) {
            System.out.println("Cliente não cadastrado.");
        }
    }
        //Imprime no console um relatório geral do anúncio
    public void gerarRelatorioAnuncios() {

        System.out.println("ANÚNCIO: " + nomeAnuncio);
        System.out.println("Nome do Cliente: " + nomeCliente);
        System.out.println("Data de Ínício do Anúncio: " + dataInicio);
        System.out.println("Data de Término do Anúncio: " + dataTermino);
        System.out.printf("Valor Diário Investido no Anúncio: R$ %.2f", valorDia);
        System.out.printf("\nValor Total Investido no Anúncio: R$ %.2f", calc.getValorTotal());
        System.out.printf("\nQuantidade Máxima Estimada de Visualizações: %.2f", calc.calcularVisualizacao());
        System.out.printf("\nQuantidade Máxima Estimada de Cliques: %.2f", calc.calcularClique());
        System.out.printf("\nQuantidade Máxima Estimada de Compartilhamentos: %.2f", calc.calcularCompartilhamento());
        System.out.println("\n---------------------------------------------------------------------------");
    }
        //Montagem do sistema de cadastro
    public void iniciarGerenciamentoAnuncios() throws InterruptedException {
        int escolha;
        int selecao;
        int filtro;
        int quantidadeAnuncio = 2;

        System.out.println("===========================================================");
        System.out.printf("%-14s%-10s", "", "SISTEMA DE CADASTRO DE ANÚNCIOS");
        System.out.println("\n===========================================================");

        do {
            System.out.println("\nQuantos anúncios deseja cadastrar?");
            quantidadeAnuncio = in.nextInt();
            in.nextLine();
            System.out.println("\n===========================================================");

            for (int i = 0; i < quantidadeAnuncio; i++) {
                indice = i;
                inserirDados();
                cadastrarAnuncio();
                System.out.println("\n===========================================================");
            }

            System.out.println("\n===========================================================================");
            System.out.printf("%-24s%-10s", "", "RELATÓRIO GERAL DE ANÚNCIOS");
            System.out.println("\n===========================================================================\n");

            for (int i = 0; i < lista.size(); i++) {
                indice = i;
                buscarTodosAnuncios();
                gerarRelatorioAnuncios();
            }

            Thread.sleep(8000);

            do {
                System.out.println("\nDeseja filtrar o relatório?" +
                        "\n1. Sim" +
                        "\n2. Não");
                escolha = in.nextInt();
                in.nextLine();

                switch (escolha) {
                    case 1:
                        do {
                            System.out.println("\nComo deseja filtrar o relatório?" +
                                    "\n1. Por cliente" +
                                    "\n2. Por intervalo de tempo");
                            filtro = in.nextInt();

                            if (filtro == 1) {
                                System.out.print("\nNome do cliente: ");
                                nome = in.next();
                                System.out.println("\n===========================================================================");
                                System.out.printf("%-21s%-10s", "", "RELATÓRIO DE ANÚNCIOS POR CLIENTES");
                                System.out.println("\n===========================================================================\n");
                                buscarCliente();

                            } else if (filtro == 2) {
                                inserirIntervaloTempo();
                                System.out.println("\n===========================================================================");
                                System.out.printf("%-15s%-10s", "", "RELATÓRIO DE ANÚNCIOS POR INTERVALO DE TEMPO");
                                System.out.println("\n===========================================================================\n");
                                buscarIntervaloTempo();

                            } else {
                                System.out.println("Código desconhecido." +
                                        "\nTente novamente.");
                            }

                        } while (filtro < 1 || filtro > 2);

                        break;

                    case 2:
                        System.out.println("\nCadastro finalizado.");
                        System.exit(0);

                    default:
                        System.out.println("\nCódigo desconhecido." +
                                "\nTente novamente.");
                        break;
                }

            } while (escolha < 1 || escolha > 2);

            do {
                System.out.println("\nDeseja realizar novo cadastro?" +
                        "\n1. Sim" +
                        "\n2. Não");
                selecao = in.nextInt();
                in.nextLine();

                if (selecao != 1) {

                    switch (selecao) {
                        case 2:
                            System.out.println("\nCadastro finalizado.");
                            System.exit(0);

                        default:
                            System.out.println("\nCódigo desconhecido." +
                                    "\nTente novamente.");
                            break;
                    }
                }

            } while (selecao < 1 || selecao > 2);

        } while (selecao == 1);

        in.close();
    }

    public static void main(String[] args) throws InterruptedException{

        Cadastro cad = new Cadastro();

        cad.iniciarGerenciamentoAnuncios();
    }
}
