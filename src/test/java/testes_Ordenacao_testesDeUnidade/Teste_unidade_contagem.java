package testes_Ordenacao_testesDeUnidade;

import Base.Aleatorio;
import EstruturasDeDados.Lista;
import Ordenacao.Contagem;
import org.junit.Test;

public class Teste_unidade_contagem{

    @Test public void contagem(){
        Lista<Integer> l = Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Contagem.ordena(l);
        l.imprime();
    }
}
