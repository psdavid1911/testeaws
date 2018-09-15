package testes_Ordenação_testesEficiencia;

import Base.Aleatorio;
import Estruturas.Par;
import Estruturas.Serie;
import EstruturasDeDados.Lista;
import Graficos.Grafico;
import Ordenacao.Rapido;
import java.util.ArrayList;
import org.junit.Test;

public class Teste_eficiencia_rapido{

    @Test public void teste_eficiencia_rapido(){
        Lista<Integer> tamanhos=new Lista<>(1000, 10000, 20000, 30000, 60000, 70000, 80000, 90000, 100000);
        Lista<Lista<Integer>> listasDesordenadas=new Lista<>();
        ArrayList<Par<Integer, Long>> pares=new ArrayList<>();
        for( Integer t:tamanhos )
            listasDesordenadas.add(Aleatorio.novaLista(t, -10, 10));
        for( int i=0; i < listasDesordenadas.size(); i++ ){
            Long temp=System.currentTimeMillis();
            Rapido.ordena(listasDesordenadas.get(i));
            pares.add(new Par(tamanhos.get(i), System.currentTimeMillis() - temp));
        }
        Grafico.criaGrafico(
                new Serie("Tempos(ms)", pares),
                "Grafico Metodo Rapido Melhor Caso",
                "Tamanho das listas",
                "Tempos de construção em milissegundos",
                "graficos/rapido_m_caso",
                800,
                600
        );
    }
}
