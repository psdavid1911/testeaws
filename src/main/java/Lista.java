
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Lista<T extends Comparable<T>> extends ArrayList<T> implements Iterable<T>,Comparable<Lista<T>>{

    public Lista(T... elementos){
        super(asList(elementos));
    }

    public Lista(List<T> lista){
        super(lista);
    }

    @Override
    public int compareTo(Lista<T> o){
        return this.toString().compareTo(o.toString());
    }

    public Lista<T> subLista(int posicaoInicial,int posicaoFinal){
        return new Lista(subList(posicaoInicial,posicaoFinal));
    }

    /**
     * Exemplo de uso: listaQualquer.embaralha(new Random());
     *
     * @param valorAleatorio
     */
    public void embaralha(Random valorAleatorio){
        for(int i=size();i>1;i--)
            trocaElementos(i-1,valorAleatorio.nextInt(i));
    }

    /**
     * Muda elementos de posicao. Método INSEGURO !!!
     *
     * @param posicao1
     * @param posicao2
     */
    public void trocaElementos(int posicao1,int posicao2){
        T tmp=get(posicao1);
        set(posicao1,get(posicao2));
        set(posicao2,tmp);
    }

    /**
     * Muda elementos de posição. Cuidado ao usar esta opcao, lembre-se de que
     * os elementos de uma lista podem se repetir, nesse caso ele o usa a
     * primeira ocorrência como referência.
     *
     * @param elemento1
     * @param elemento2
     */
    public void trocaElementos(T elemento1,T elemento2){
        int indice1=indexOf(elemento1);
        int indice2=indexOf(elemento2);
        if(indice1==-1||indice2==-1)return;
        set(indice1,elemento1);
        set(indice2,elemento2);
    }

    /**
     * Não foi criado ainda, não use
     */
    public void inverte(){
    }

    public void ordena(){
        sort(null);
    }

    public void ordena(Comparator comparador){
        Collections.sort(this,comparador);
    }

    public void imprime(){
        System.out.println(toString());
    }

    public T pegaAleatorio(){
        return get((new Random()).nextInt(size()));
    }
}
