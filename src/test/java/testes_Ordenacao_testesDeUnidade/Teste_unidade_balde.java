package testes_Ordenacao_testesDeUnidade;

import org.junit.Test;

import Base.Aleatorio;
import EstruturasDeDados.Lista;
import Ordenacao.Balde;

public class Teste_unidade_balde{

    @Test public void balde(){
        Lista<Integer> l = Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Balde.ordena(l);
        l.imprime();
    }
}
