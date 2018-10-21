package testes_Ordenacao_testesDeUnidade;

import org.junit.jupiter.api.Test;

import Base.Aleatorio;
import EstruturasDeDados.Lista;
import Ordenacao.Bolha;

public class Teste_unidade_bolha{

    @Test public void bubble(){
        Lista<Integer> l = Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Bolha.ordena(l);
        l.imprime();
    }
}
