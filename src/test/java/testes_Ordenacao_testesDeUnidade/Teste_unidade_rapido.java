package testes_Ordenacao_testesDeUnidade;

import org.junit.Test;

import Base.Aleatorio;
import EstruturasDeDados.Lista;
import Ordenacao.Rapido;

public class Teste_unidade_rapido{

    @Test public void rapido(){
        Lista<Integer> l = Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Rapido.ordena(l);
        l.imprime();
    }
}
