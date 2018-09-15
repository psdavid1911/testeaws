package testes_Ordenação_testesEficiencia;

import Base.Aleatorio;
import Graficos.Grafico;
import Estruturas.Par;
import Estruturas.Serie;
import EstruturasDeDados.Lista;
import Ordenacao.Mistura;
import java.util.ArrayList;
import org.junit.Test;

public class Teste_eficiencia_mistura{

    @Test public void teste_eficiencia_mistura(){
        Lista<Integer> tamanhos=new Lista<>(1000, 10000, 20000, 30000, 60000, 70000, 80000, 90000, 100000);
        Lista<Lista<Integer>> listas=new Lista<>();
        ArrayList<Par<Integer, Long>> pares=new ArrayList<>();
        for(Integer t:tamanhos)
            listas.add(Aleatorio.novaLista(t, -10, 10));
        for(int i=0; i<listas.size(); i++){
            Long temp=System.currentTimeMillis();
            Mistura.ordena(listas.get(i));
            pares.add(new Par(tamanhos.get(i), System.currentTimeMillis()-temp));
        }
        Grafico.criaGrafico(
                new Serie("Tempos(ms)", pares),
                "Grafico Metodo Mistura Melhor Caso",
                "Tamanho das listas",
                "Tempos de construção em milissegundos",
                "graficos/mistura_m_caso",
                800,
                600
        );
    }
}
