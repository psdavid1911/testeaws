package EstruturasDeDados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Arrays.asList;

public class Lista<T extends Comparable<T>> extends ArrayList<T> implements Iterable<T>, Comparable<Lista<T>>{

    public ArrayList<Dupla<Integer>> historicoDeTrocas = new ArrayList<>();

    public Lista(T... elementos){
        super(asList(elementos));
    }

    public Lista(List<T> lista){
        super(lista);
    }

    public Lista(){
        super();
    }

    public Lista(T valor, int capacidade){
        super();
        for (int i = 0; i < capacidade; i++)
            this.add(valor);
    }

    @Override
    public int compareTo(Lista<T> o){
        return this.toString().compareTo(o.toString());
    }

    public void embaralha(Random valorAleatorio){
        Collections.shuffle(this);
    }

    public Stream<T> filtro(Predicate<T> predicado){
        return stream().filter(predicado);
    }

    public void imprime(){
        System.out.println(toString());
    }

    public void inverte(){
        Collections.reverse(this);
    }

    public T maiorElemento(){
        return Collections.max(this);
    }

    public int maiorLargura(){
        int largura = 0;
        for (T elemelemento : this){
            int aux = elemelemento.toString().length();
            largura = aux > largura ? aux : largura;
        }
        return largura;
    }

    public T menorElemento(){
        return Collections.min(this);
    }

    public void ordena(Comparator comparador){
        Collections.sort(this, comparador);
    }

    public void ordena(){
        Collections.sort(this);
    }

    public void paraCada(Consumer<? super T> expressaoLambda){
        forEach(expressaoLambda);
    }

    public T pega(int posicao){
        return get(posicao);
    }

    public T pegaAleatorio(){
        return pega((new Random()).nextInt(size()));
    }

    public T pegaElemento(T elemento){
        return get(indexOf(elemento));
    }

    public void preecher(T valor){
        Collections.fill(this, valor);
    }

    public void preecher(int indiceInicial, int indiceFinal, T valor){
        for (int i = indiceInicial; i < indiceFinal; i++)
            this.set(i, valor);
    }

    public ArrayList<T> subLista(int posicaoInicial, int posicaoFinal){
        return new ArrayList<>(subList(posicaoInicial, posicaoFinal));
    }

    public Lista<T> sublista(Predicate<T> expressaoLambda){
        return new Lista(filtro(expressaoLambda).collect(Collectors.toList()));
    }

    public void trocaElementos(int posicao1, int posicao2){
        T tmp = get(posicao1);
        set(posicao1, get(posicao2));
        set(posicao2, tmp);
        historicoDeTrocas.add(new Dupla<>(posicao1, posicao2));
    }

    public void trocaElementos(T elemento1, T elemento2){
        int i1 = indexOf(elemento1);
        int i2 = indexOf(elemento2);
        trocaElementos(i1, i2);
    }
}
