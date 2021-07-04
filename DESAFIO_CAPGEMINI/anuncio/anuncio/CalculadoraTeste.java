package anuncio;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTeste {

    Calculadora calc = new Calculadora();

    @Test
    public void testeCalcularVisualizacao() {
        calc.setValorTotal(2);

        Assert.assertEquals(3840000, calc.calcularVisualizacao(), 0);
    }

    @Test
    public void testeCalcularClique() {
        calc.setValorTotal(2);

        Assert.assertEquals(400000, calc.calcularClique(), 0);
    }

    @Test
    public void testecalcularCompartilhamento() {
        calc.setValorTotal(2);

        Assert.assertEquals(69120, calc.calcularCompartilhamento(), 0);
    }
}
