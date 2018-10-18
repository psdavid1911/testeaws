package EstruturasDeDados;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Não pode conter elementos duplicados
 *
 * @author david
 */
public class Conjunto<T> extends TreeSet<T>{

    /**
     * É o conjunto da união, menos a intercessão dos conjuntos
     *
     * @param colecao
     *
     * @return
     */
    public TreeSet<T> diferencaSimetrica(Collection<T> colecao){
        TreeSet<T> conjuntoDiferecaSimetrica = this;
        conjuntoDiferecaSimetrica.addAll(colecao);
        TreeSet<T> tmp = this;
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
    public TreeSet<T> duplicados(Collection<T> colecao){
        TreeSet<T> unicos = new TreeSet<>();
        TreeSet<T> duplicados = new TreeSet<>();
        for (T elemento : colecao)
            if (!unicos.add(elemento))
                duplicados.add(elemento);
        return duplicados;
    }

    /**
     * So faz sentido se usado com uma colecao externa, pois a própria classe já
     * se assegura de não mater elementos repetidos.
     *
     * @param colecao
     *
     * @return
     */
    public TreeSet<T> unicos(Collection<T> colecao){
        TreeSet<T> unicos = new TreeSet<>();
        TreeSet<T> duplicados = new TreeSet<>();
        for (T elemento : colecao)
            if (!unicos.add(elemento))
                duplicados.add(elemento);
        unicos.removeAll(duplicados);
        return unicos;
    }
}
