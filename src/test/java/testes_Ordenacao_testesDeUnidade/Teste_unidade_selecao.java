package testes_Ordenacao_testesDeUnidade;

import org.junit.jupiter.api.Test;

import Base.Aleatorio;
import EstruturasDeDados.Lista;
import Ordenacao.Selecao;

public class Teste_unidade_selecao{

    @Test public void selecao(){
        Lista<Integer> l = Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Selecao.ordena(l);
        l.imprime();
    }
}
