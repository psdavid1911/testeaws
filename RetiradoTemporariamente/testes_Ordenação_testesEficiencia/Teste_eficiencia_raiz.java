package testes_Ordenação_testesEficiencia;

import Base.Aleatorio;
import Estruturas.Par;
import Estruturas.Serie;
import EstruturasDeDados.Lista;
import Ordenacao.Raiz;
import java.util.ArrayList;
import org.junit.Test;
import static Graficos.Grafico.criaGrafico;

public class Teste_eficiencia_raiz{

    @Test public void teste_eficiencia_raiz(){
        Lista<Integer> tamanhos = new Lista<>(1000, 10000, 20000, 30000, 60000, 70000, 80000, 90000, 100000);
        Lista<Lista<Integer>> listas = new Lista<>();
        ArrayList<Par<Integer, Long>> pares = new ArrayList<>();
        for (Integer t : tamanhos)
            listas.add(Aleatorio.novaLista(t, 0, 100));
        for (int i = 0; i < listas.size(); i++){
            Long temp = System.currentTimeMillis();
            Raiz.ordena(listas.get(i));
            pares.add(new Par((double) tamanhos.get(i), (double) System.currentTimeMillis() - temp));
        }
        criaGrafico(
                new Serie("Tempos(ms)", pares),
                "Grafico Metodo Raiz Melhor Caso",
                "Tamanho das listas",
                "Tempos de construção em milissegundos",
                "graficos/raiz_m_caso",
                800,
                600
        );
    }
}
