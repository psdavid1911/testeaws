package testes_Ordenacao_testesDeUnidade;

import org.junit.jupiter.api.Test;

import Base.Aleatorio;
import EstruturasDeDados.Lista;
import Ordenacao.Mistura;

public class Teste_unidade_mistura{

    @Test public void mistura(){
        Lista<Integer> l = Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Mistura.ordena(l);
        l.imprime();
    }
}
