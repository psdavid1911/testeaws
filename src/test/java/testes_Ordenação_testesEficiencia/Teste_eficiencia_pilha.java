package testes_Ordenação_testesEficiencia;

import Base.Aleatorio;
import Base.Par;
import Base.Serie;
import EstruturasDeDados.Lista;
import Ordenacao.Pilha;
import java.util.ArrayList;
import org.junit.Test;
import static Base.Grafico.criaGrafico;

public class Teste_eficiencia_pilha{

    @Test public void teste_eficiencia_pilha(){
        Lista<Integer> tamanhos=new Lista<>(1000, 10000, 20000, 30000, 60000, 70000, 80000, 90000, 100000);
        Lista<Lista<Integer>> listas=new Lista<>();
        ArrayList<Par<Integer, Long>> pares=new ArrayList<>();
        for(Integer t:tamanhos)
            listas.add(Aleatorio.novaLista(t, -10, 10));
        for(int i=0; i<listas.size(); i++){
            Long temp=System.currentTimeMillis();
            Pilha.ordena(listas.get(i));
            pares.add(new Par(new Integer(tamanhos.get(i)).doubleValue(), new Long(System.currentTimeMillis()-temp).doubleValue() ));
        }
        criaGrafico(
                new Serie("Tempos(ms)", pares),
                "Grafico Metodo Pilha Melhor Caso",
                "Tamanho das listas",
                "Tempos de construção em milissegundos",
                "graficos/pilha_m_caso",
                800,
                600
        );
    }
}
