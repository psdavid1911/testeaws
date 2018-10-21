package testes_Ordenacao_testesDeUnidade;

import org.junit.Test;

import Base.Aleatorio;
import EstruturasDeDados.Lista;
import Ordenacao.Raiz;

public class Teste_unidade_raiz{

    @Test public void raiz(){
        Lista<Integer> l = Aleatorio.novaLista(50, 0, 99);
        l.imprime();
        Raiz.ordena(l);
        l.imprime();
    }
}
