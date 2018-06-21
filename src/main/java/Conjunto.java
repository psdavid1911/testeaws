
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Não pode conter elementos duplicados
 *
 * @author david
 */
public class Conjunto<T> extends HashSet<T> implements Iterable<T>{

    public void intersecaoCom(Collection<T> colecao){
        retainAll(colecao);
    }

    /**
     * É o conjunto da união, menos a intercessão dos conjuntos
     *
     * @param colecao
     *
     * @return
     */
    public Set<T> diferencaSimetrica(Collection<T> colecao){
        Set<T> conjuntoDiferecaSimetrica=this;
        conjuntoDiferecaSimetrica.addAll(colecao);
        Set<T> tmp=this;
        tmp.retainAll(colecao);
        conjuntoDiferecaSimetrica.removeAll(tmp);
        return conjuntoDiferecaSimetrica;
    }

    /**
     * So faz sentido se usado com uma colecao externa, pois a própria classe já
     * se assegura de não mater elementos repetidos.
     *
     * @param colecao
     *
     * @return
     */
    public Set<T> unicos(Collection<T> colecao){
        Set<T> unicos=new HashSet<T>();
        Set<T> duplicados=new HashSet<T>();
        for(T elemento:colecao)
            if(!unicos.add(elemento))
                duplicados.add(elemento);
        unicos.removeAll(duplicados);
        return unicos;
    }

    /**
     * So faz sentido se usado com uma colecao externa, pois a própria classe já
     * se assegura de não mater elementos repetidos.
     *
     * @param colecao
     *
     * @return
     */
    public Set<T> duplicados(Collection<T> colecao){
        Set<T> unicos=new HashSet<T>();
        Set<T> duplicados=new HashSet<T>();
        for(T elemento:colecao)
            if(!unicos.add(elemento))
                duplicados.add(elemento);
        return duplicados;
    }
}
