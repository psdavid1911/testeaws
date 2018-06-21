
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
                Lista<T> adjascenciasAnteriores=grafo.get(vertice);
                adjascenciasAnteriores.add(verticeAdjascente);
                grafo.put(vertice,adjascenciasAnteriores);
            }else {
                Lista<T> adjascenciasAnteriores=new Lista<T>();
                adjascenciasAnteriores.add(verticeAdjascente);
                grafo.put(vertice,adjascenciasAnteriores);
            }
    }

    public void adicionaVertice(T vertice){
        if(!existeVertice(vertice))grafo.put(vertice,new Lista<T>());
    }

    public void remove(T elemento){
        grafo.remove(elemento);
        for(Entry<T,Lista<T>> entrada:grafo.entrySet()){
            Lista<T> lista=entrada.getValue();
            if(lista.contains(elemento))
                lista.remove(elemento);
        }
    }

    public boolean existeVertice(T vertice){
        return grafo.containsKey(vertice);
    }

    public boolean existeAresta(T verticeInicio,T verticeAdjascente){
        Lista<T> listaAdjascencias=grafo.get(verticeInicio);
        if(listaAdjascencias!=null)
            return listaAdjascencias.contains(verticeAdjascente);
        else
            return false;
    }

    public Par< T,Lista<T>> pegaElementoAleatorio(){
        Lista<T> lista=new Lista<T>();
        for(Entry<T,Lista<T>> entrada:grafo.entrySet())
            lista.add(entrada.getKey());
        T verticeEscolhido=lista.pegaAleatorio();
        return new Par<T,Lista<T>>(verticeEscolhido,grafo.get(verticeEscolhido));
    }

    public int numeroSaidas(T vertice){
        return grafo.get(vertice).size();
    }

    public T pegaVerticeMaisRamos(){
        T vertice=pegaElementoAleatorio().getX();
        for(Map.Entry<T,Lista<T>> elemento:grafo.entrySet())
            if(elemento.getValue().size()>grafo.get(vertice).size())
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
        return grafo.get(conteudo);
    }

    public Conjunto<T> pegaNaoAdjascentes(T conteudo){
        Conjunto<T> conjunto=new Conjunto<T>();
        for(Entry<T,Lista<T>> entrada:grafo.entrySet())conjunto.add(entrada.getKey());
        conjunto.removeAll(grafo.get(conteudo));
        return conjunto;
    }

    public Lista<T> pegaVertices(){
        Lista<T> vertices=new Lista<T>();
        for(Entry<T,Lista<T>> entrada:grafo.entrySet())vertices.add(entrada.getKey());
        return vertices;
    }

    public int tamanho(){
        return grafo.size();
    }

    @Override
    public String toString(){
        String s="";
        for(Map.Entry<T,Lista<T>> par:grafo.entrySet()){
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
        for(Entry<T,Lista<T>> entrada:grafo.entrySet()){
            T chave=entrada.getKey();
            Lista<T> lista=entrada.getValue();
            System.out.printf("%-"+tamanhoDaChave+"s |   %s \n",chave,lista.toString());
        }
    }
}
