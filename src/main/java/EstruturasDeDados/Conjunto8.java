package EstruturasDeDados;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Não pode conter elementos duplicados
 *
 * @author david
 */
public class Conjunto8<T> implements Iterable<T>{

    Set<T> conjunto=new HashSet<T>();

    public void adiciona(T elemento){
        conjunto.add(elemento);
    }

    public boolean vazio(){
        return conjunto.isEmpty();
    }

    /**
     * Também chamado de cardinalidade.
     *
     * @return
     */
    public int tamanho(){
        return conjunto.size();
    }

    public void remove(T elemento){
        conjunto.remove(elemento);
    }

    public boolean contem(T elemento){
        return conjunto.contains(elemento);
    }

    public void limpa(){
        conjunto.clear();
    }

    /**
     * Uma colecao se refere à todos aquelas classes e abstrações em java que
     * pertencem à Collections, ver hieraquia na documentação do java. Em se
     * tratando de conjuntos essa é a operação de UNIÃO
     *
     * @param colecao
     */
    public void adicionaTodos(Collection<T> colecao){
        conjunto.addAll(colecao);
    }

    /**
     * Uma colecao se refere à todos aquelas classes e abstrações em java que
     * pertencem à Collections, ver hieraquia na documentação do java.
     *
     * @param colecao
     */
    public boolean contemTodos(Collection<T> colecao){
        return conjunto.containsAll(colecao);
    }

    /**
     * Uma colecao se refere à todos aquelas classes e abstrações em java que
     * pertencem à Collections, ver hieraquia na documentação do java. Em se
     * tratando de conjuntos essa é a operação de UNIÃO
     *
     * @param colecao
     */
    public void uneCom(Collection<T> colecao){
        conjunto.addAll(colecao);
    }

    public void intersecaoCom(Collection<T> colecao){
        conjunto.retainAll(colecao);
    }

    public void diferencaCom(Collection<T> colecao){
        conjunto.removeAll(colecao);
    }

    /**
     * Pode ser entendido como o tamanho do conjunto, sua quantidade de
     * elementos
     *
     * @return
     */
    public int cardinalidade(){
        return conjunto.size();
    }

    /**
     * Uma colecao se refere à todos aquelas classes e abstrações em java que
     * pertencem à Collections, ver hieraquia na documentação do java. Um
     * subconjunto, é aquele cujos elementos existem no conjunto atual
     *
     * @param colecao
     *
     * @return
     */
    public boolean eSubconjunto(Collection<T> colecao){
        return conjunto.containsAll(colecao);
    }

    /**
     * É o conjunto da união, menos a intercessão dos conjuntos
     *
     * @param colecao
     *
     * @return
     */
    public Set<T> diferencaSimetrica(Collection<T> colecao){
        Set<T> conjuntoDiferecaSimetrica=conjunto;
        conjuntoDiferecaSimetrica.addAll(colecao);
        Set<T> tmp=conjunto;
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

    private Set<T> original(){
        return conjunto;
    }

    public void paraCada(Consumer<? super T> expressaoLambda){
        conjunto.forEach(expressaoLambda);
    }

    @Override
    public Iterator<T> iterator(){
        return conjunto.iterator();
    }

    @Override
    public String toString(){
        return "Conjunto8{"+"conjunto="+conjunto+'}';
    }
}
