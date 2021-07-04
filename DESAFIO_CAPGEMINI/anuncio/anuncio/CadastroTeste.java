package anuncio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class CadastroTeste {
    String teste = "[X Seminário de Letras, Universidade do Norte, 20/02/2020, 20/03/2020, 3.0, 9.0]";

    Cadastro cad = new Cadastro();

    @Test
    public void testeCalcularValorTotal() {
        cad.setValorDia(3);
        cad.setDataI(LocalDate.now());
        cad.setDataT(LocalDate.now().plusDays(3));

        Assert.assertEquals(9, cad.calcularValorTotal(),0);
    }

    @Before
    public void iniciarBusca() {
        cad.setNomeAnuncio("X Seminário de Letras");
        cad.setNomeCliente("Universidade do Norte");
        cad.setDataInicio("20/02/2020");
        cad.setDataTermino("20/03/2020");
        cad.setValorDia(2);
        cad.setValorDia(3);
        cad.setDataI(LocalDate.now());
        cad.setDataT(LocalDate.now().plusDays(3));
        cad.calcularValorTotal();

    }

    @Test
    public void testeCadastrarAnuncio() {
        String teste = "[[X Seminário de Letras, Universidade do Norte, 20/02/2020, 20/03/2020, 3.0, 9.0]]";

        Assert.assertEquals(teste, cad.cadastrarAnuncio().toString());
    }



    @Test
    public void testeBuscarTodosAnuncios() {
        cad.cadastrarAnuncio();
        cad.buscarTodosAnuncios();

        ArrayList<String> teste1 = new ArrayList<>();
        teste1.add(cad.A[0]);
        teste1.add(cad.A[1]);
        teste1.add(cad.A[2]);
        teste1.add(cad.A[3]);
        teste1.add(cad.A[4]);
        teste1.add(cad.A[5]);

        Assert.assertEquals(teste, teste1.toString());
    }

    @Test
    public void testeBuscarCliente() {
        cad.setNome("Universidade do Norte");
        cad.cadastrarAnuncio();
        cad.buscarCliente();

        ArrayList<String> teste1 = new ArrayList<>();
        teste1.add(cad.A[0]);
        teste1.add(cad.A[1]);
        teste1.add(cad.A[2]);
        teste1.add(cad.A[3]);
        teste1.add(cad.A[4]);
        teste1.add(cad.A[5]);

        Assert.assertEquals(teste, teste1.toString());
    }

    @Test
    public void testeBuscarIntervaloTempo() {
        cad.setPeriodoInicial(LocalDate.of(2020,02,20));
        cad.setPeriodoFinal(LocalDate.of(2020, 02, 25));
        cad.cadastrarAnuncio();
        cad.buscarIntervaloTempo();

        ArrayList<String> teste1 = new ArrayList<>();
        teste1.add(cad.A[0]);
        teste1.add(cad.A[1]);
        teste1.add(cad.A[2]);
        teste1.add(cad.A[3]);
        teste1.add(cad.A[4]);
        teste1.add(cad.A[5]);

        Assert.assertEquals(teste, teste1.toString());
    }
}
