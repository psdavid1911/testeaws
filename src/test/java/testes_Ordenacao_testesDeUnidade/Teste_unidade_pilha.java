package testes_Ordenacao_testesDeUnidade;

import org.junit.jupiter.api.Test;

import Base.Aleatorio;
import EstruturasDeDados.Lista;
import Ordenacao.Pilha;

public class Teste_unidade_pilha{

    @Test public void pilha(){
        Lista<Integer> l = Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Pilha.ordena(l);
        l.imprime();
    }
}
