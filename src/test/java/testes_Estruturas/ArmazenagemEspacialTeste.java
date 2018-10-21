package testes_Estruturas;

import org.junit.jupiter.api.Test;

import Estruturas.ArmazenagemEspacial;

public class ArmazenagemEspacialTeste{

    /**
     * (ABAIXO) 2 dimensoes == tabela. E 4 de largura == tabela com 4 colunas
     */
    ArmazenagemEspacial<Integer> tabela = new ArmazenagemEspacial<Integer>(2, 4);

    public ArmazenagemEspacialTeste(){
    }

    @Test public void indiceParaPosicaoTeste(){
        imprime("\n%d\n", tabela.indiceParaPosicao(1, 2));
    }

    @Test public void adicionaTeste(){
        for (int i = 0; i < tabela.nItens; i++)
            tabela.adiciona(i * i, i);
        for (int i = 0; i < tabela.nItens; i++)
            imprime("" + tabela.pega(i));
    }

    public void imprime(String s, Object... a){
        System.out.printf(s, a);
        System.out.printf("\n");
    }
}
