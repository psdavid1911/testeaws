package EstruturasDeDados;
import EstruturasDeDados8.Conjunto8;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Grafo<T extends Comparable<T>>{

    TabelaHash<T,Lista<T>> grafo=new TabelaHash<T,Lista<T>>();

    public void adicionaAresta(T vertice,T verticeAdjascente){
        if(!existeVertice(verticeAdjascente))
            adicionaVertice(verticeAdjascente);
        if(!existeAresta(vertice,verticeAdjascente))
            if(existeVertice(vertice)){
                Lista<T> adjascenciasAnteriores=grafo.pega(vertice);
                adjascenciasAnteriores.adiciona(verticeAdjascente);
                grafo.adiciona(vertice,adjascenciasAnteriores);
            }else {
                Lista<T> adjascenciasAnteriores=new Lista<T>();
                adjascenciasAnteriores.adiciona(verticeAdjascente);
                grafo.adiciona(vertice,adjascenciasAnteriores);
            }
    }

    public void adicionaVertice(T vertice){
        if(!existeVertice(vertice))grafo.adiciona(vertice,new Lista<T>());
    }

    public void remove(T elemento){
        grafo.remove(elemento);
        for(Entry<T,Lista<T>> entrada:grafo.conjunto()) {
            T par=entrada.getKey();
            Lista<T> lista=entrada.getValue();
            if(lista.contem(elemento))
                lista.remove(elemento);
        }
    }

    public boolean existeVertice(T vertice){
        return grafo.contemChave(vertice);
    }

    public boolean existeAresta(T verticeInicio,T verticeAdjascente){
        Lista<T> listaAdjascencias=grafo.pega(verticeInicio);
        if(listaAdjascencias!=null)
            return listaAdjascencias.contem(verticeAdjascente);
        else
            return false;
    }

    public Par< T,Lista<T>> pegaElementoAleatorio(){
        Lista<T> lista=new Lista<T>();
        for(Entry<T,Lista<T>> entrada:grafo.conjunto())
            lista.adiciona(entrada.getKey());
        T verticeEscolhido=lista.pegaAleatorio();
        return new Par< T,Lista<T>>(verticeEscolhido,grafo.pega(verticeEscolhido));
    }

    public int numeroSaidas(T vertice){
        return grafo.pega(vertice).tamanho();
    }

    public T pegaVerticeMaisRamos(){
        T vertice=pegaElementoAleatorio().getX();
        for(Map.Entry<T,Lista<T>> elemento:grafo.conjunto())
            if(elemento.getValue().tamanho()>grafo.pega(vertice).tamanho())
                vertice=elemento.getKey();
        return vertice;
    }

    /**
     * Pega a lista associada a esta chave
     *
     * @param conteudo
     *
     * @return Nulo se nenhum valor for encontrado
     */
    public Lista<T> pegaAdjascentes(T conteudo){
        return grafo.pega(conteudo);
    }

    public Conjunto8<T> pegaNaoAdjascentes(T conteudo){
        Conjunto8<T> conjunto=new Conjunto8<T>();
        for(Entry<T,Lista<T>> entrada:grafo.conjunto()) conjunto.adiciona(entrada.getKey());
        conjunto.diferencaCom(grafo.pega(conteudo));
        return conjunto;
    }

    public Lista<T> pegaVertices(){
        Lista<T> vertices=new Lista<T>();
        for(Entry<T,Lista<T>> entrada:grafo.conjunto()) vertices.adiciona(entrada.getKey());
        return vertices;
    }

    public int tamanho(){
        return grafo.size();
    }

    @Override
    public String toString(){
        String s="";
        for(Map.Entry<T,Lista<T>> par:grafo.conjunto()) {
            s+=par.getKey().toString();
            s+="      ";
            s+=par.getValue().toString();
            s+="\n";
        }
        return s;
    }

    public Set<Map.Entry<T,Lista<T>>> conjunto(){
        return grafo.entrySet();
    }

    public void imprime(int tamanhoDaChave){
        System.out.printf("%-"+tamanhoDaChave+"s |   %s \n\n","VERTICE","VERTICES DE DESTINO");
        for(Map.Entry<T,Lista<T>> entrada:grafo.conjunto()) {
            T chave=entrada.getKey();
            Lista<T> lista=entrada.getValue();
            System.out.printf("%-"+tamanhoDaChave+"s |   %s \n",chave,lista.toString());
        }
    }
}
