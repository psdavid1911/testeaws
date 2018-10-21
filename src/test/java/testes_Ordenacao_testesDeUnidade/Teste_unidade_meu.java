package testes_Ordenacao_testesDeUnidade;

import org.junit.jupiter.api.Test;

import Base.Aleatorio;
import EstruturasDeDados.Lista;
import Ordenacao.Meu;

public class Teste_unidade_meu{

    @Test public void meu(){
        Lista<Integer> l = Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Meu.ordena(l);
        l.imprime();
    }
}
