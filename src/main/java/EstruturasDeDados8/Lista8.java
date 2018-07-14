package EstruturasDeDados8;

import EstruturasDeDados.Lista;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Cuidado, podem haver elementos duplicados em uma lista. Dica, pode realizar
 * operações em sublistas, tais como remover todos os elementos do interior
 *
 * @author david
 * @param <T>
 */
public class Lista8<T extends Comparable<T>> extends Lista<T> implements Iterable<T>{
    public Lista8(List<T> lista){
        super(lista);
    }

    public Lista8(){
        super();
    }

    public Stream<T> fluxo(){
        return this.stream();
    }

    public Stream<T> filtro(Predicate<T> predicado){
        return stream().filter(predicado);
    }

    public Lista8<T> sublista(Predicate<T> expressaoLambda){
        return new Lista8(filtro(expressaoLambda).collect(Collectors.toList()));
    }

    public void paraCada(Consumer<? super T> expressaoLambda){
        forEach(expressaoLambda);
    }

    public T pegaAleatorio(){
        return pega((new Random()).nextInt(tamanho()));
    }
}
