package anuncio;

import java.util.Scanner;

public class Calculadora {
    float valorTotal;
    float visualizacao;
    float clique;
    float compartilhamento;

    Scanner in = new Scanner(System.in);

    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
        //Cálculo da quantidade de visualização do anúncio a partir do valor total
    public float calcularVisualizacao() {
        visualizacao = valorTotal * 1920000;
        return visualizacao;
    }
        //Cálculo da quantidade de cliques do anúncio a partir do valor total
    public float calcularClique() {
        clique = valorTotal * 230400;
        return clique;
    }
        //Cálculo da quantidade de compartilhamentos do anúncio a partir do valor total
    public float calcularCompartilhamento() {
        compartilhamento = valorTotal * 34560;
        return compartilhamento;
    }
        //Montagem da calculadora de visualização de anúncios
    public void calculadoraVisualizacao() {

        System.out.println("================================================================================================");
        System.out.printf("%-26s%-10s", "", "CALCULADORA DE VISUALIZAÇAO DE ANÚNCIOS");
        System.out.println("\n================================================================================================\n");

        System.out.print("Valor Total Investido no Anúncio: R$ ");
        valorTotal = in.nextFloat();

        calcularVisualizacao();

        System.out.printf("\nProjeção aproximada da quantidade máxima de pessoas" +
                " que visualizarão o anúncio: %.2f", calcularVisualizacao());

        in.close();
    }

    public static void main(String[] args) {

        Calculadora gera = new Calculadora();

        gera.calculadoraVisualizacao();
    }

}