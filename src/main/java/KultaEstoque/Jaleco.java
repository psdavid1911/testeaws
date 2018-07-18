package KultaEstoque;

import EstruturasDeDados.TabelaHash;
import KultaEnumeracoes.NOME;
import KultaEnumeracoes.TAMANHO;
import java.io.Serializable;

public class Jaleco implements Serializable, Comparable<Jaleco>{
    private NOME nome;
    private String descricao;
    private TabelaHash<TAMANHO, Integer> qtde;

    public NOME getNome(){
        return nome;
    }

    public void setNome(NOME nome){
        this.nome = nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public TabelaHash<TAMANHO, Integer> getQtde(){
        return qtde;
    }

    public void setQtde(TabelaHash<TAMANHO, Integer> qtde){
        this.qtde = qtde;
    }

    @Override
    public int compareTo(Jaleco j){
        return getNome().toString().compareTo(j.getNome().toString());
    }
}
