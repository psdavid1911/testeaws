package testes_Ordenacao_testesDeUnidade;

import Base.Aleatorio;
import EstruturasDeDados.Lista;
import org.junit.Test;

public class Teste_unidade_insercao{

    @Test public void selecao(){
        Lista<Integer> l = Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Ordenacao.Insercao.ordena(l);
        l.imprime();
    }
}
