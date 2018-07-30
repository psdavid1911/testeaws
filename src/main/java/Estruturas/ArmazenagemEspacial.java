package Estruturas;
import java.util.ArrayList;

public class ArmazenagemEspacial<T>{

    public final int nDimensoes;
    public final int largura;
    public final int nItens;
    ArrayList<T> vetor;

    public ArmazenagemEspacial(int nDimensoes,int largura){
        this.nDimensoes=nDimensoes;
        this.largura=largura;
        this.nItens=largura^nDimensoes;
        vetor=new ArrayList<T>(nItens);
    }

    public void adiciona(T conteudo,int indice){
        if(indice>nItens)throw new Error("O índice é maior que o vetor");
        vetor.add(indice,conteudo);
    }

    public void adiciona(T conteudo,Integer... posicao){
        vetor.add(indiceParaPosicao(posicao),conteudo);
    }

    public int indiceParaPosicao(Integer... posicao){
        int contadorBase=posicao.length-1, base=1, indice=0;
        for(int i=posicao.length-1;i>=0;i--) {
            if(i%largura==0)base=(int)Math.pow(largura,contadorBase--);
            indice+=posicao[i]*base;
        }
        if(indice>nItens)throw new Error("O índice é maior que o vetor");
        return indice;
    }

    public T pega(int posicao){
        return vetor.get(posicao);
    }
}
