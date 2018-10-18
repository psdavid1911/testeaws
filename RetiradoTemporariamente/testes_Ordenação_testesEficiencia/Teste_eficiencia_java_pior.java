package testes_Ordenação_testesEficiencia;

import Base.Aleatorio;
import Estruturas.Par;
import Estruturas.Serie;
import EstruturasDeDados.Lista;
import Graficos.Grafico;
import Ordenacao.Java;
import java.util.ArrayList;
import org.junit.Test;

public class Teste_eficiencia_java_pior{

    @Test public void teste_eficiencia_java(){
        Lista<Integer> tamanhos = new Lista<>(1000, 10000, 20000, 30000, 60000, 70000, 80000, 90000, 100000);
        Lista<Lista<Integer>> listas = new Lista<>();
        ArrayList<Par<Integer, Long>> pares = new ArrayList<>();
        for (Integer t : tamanhos)
            listas.add(Aleatorio.novaListaPiorCaso(t, 10));
        for (int i = 0; i < listas.size(); i++){
            Long temp = System.currentTimeMillis();
            Java.ordena(listas.get(i));
            pares.add(new Par(tamanhos.get(i), System.currentTimeMillis() - temp));
        }
        Grafico.criaGrafico(
                new Serie("Tempos(ms)", pares),
                "Grafico Metodo Java Pior Caso",
                "Tamanho das listas",
                "Tempos de construção em milissegundos",
                "graficos/java_p_caso",
                800,
                600
        );
    }
}
