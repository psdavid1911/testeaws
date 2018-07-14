package EstruturasDeDados;
import EstruturasDeDados8.Conjunto8;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Grafo<T extends Comparable<T>>{

    TabelaHash<T,ListaAntiga<T>> grafo=new TabelaHash<T,ListaAntiga<T>>();

    public void adicionaAresta(T vertice,T verticeAdjascente){
        if(!existeVertice(verticeAdjascente))
            adicionaVertice(verticeAdjascente);
        if(!existeAresta(vertice,verticeAdjascente))
            if(existeVertice(vertice)){
                ListaAntiga<T> adjascenciasAnteriores=grafo.pega(vertice);
                adjascenciasAnteriores.adiciona(verticeAdjascente);
                grafo.adiciona(vertice,adjascenciasAnteriores);
            }else {
                ListaAntiga<T> adjascenciasAnteriores=new ListaAntiga<T>();
                adjascenciasAnteriores.adiciona(verticeAdjascente);
                grafo.adiciona(vertice,adjascenciasAnteriores);
            }
    }

    public void adicionaVertice(T vertice){
        if(!existeVertice(vertice))grafo.adiciona(vertice,new ListaAntiga<T>());
    }

    public void remove(T elemento){
        grafo.remove(elemento);
        for(Entry<T,ListaAntiga<T>> entrada:grafo.conjunto()) {
            T par=entrada.getKey();
            ListaAntiga<T> lista=entrada.getValue();
            if(lista.contem(elemento))
                lista.remove(elemento);
        }
    }

    public boolean existeVertice(T vertice){
        return grafo.contemChave(vertice);
    }

    public boolean existeAresta(T verticeInicio,T verticeAdjascente){
        ListaAntiga<T> listaAdjascencias=grafo.pega(verticeInicio);
        if(listaAdjascencias!=null)
            return listaAdjascencias.contem(verticeAdjascente);
        else
            return false;
    }

    public Par< T,ListaAntiga<T>> pegaElementoAleatorio(){
        ListaAntiga<T> lista=new ListaAntiga<T>();
        for(Entry<T,ListaAntiga<T>> entrada:grafo.conjunto())
            lista.adiciona(entrada.getKey());
        T verticeEscolhido=lista.pegaAleatorio();
        return new Par< T,ListaAntiga<T>>(verticeEscolhido,grafo.pega(verticeEscolhido));
    }

    public int numeroSaidas(T vertice){
        return grafo.pega(vertice).tamanho();
    }

    public T pegaVerticeMaisRamos(){
        T vertice=pegaElementoAleatorio().getX();
        for(Map.Entry<T,ListaAntiga<T>> elemento:grafo.conjunto())
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
    public ListaAntiga<T> pegaAdjascentes(T conteudo){
        return grafo.pega(conteudo);
    }

    public Conjunto8<T> pegaNaoAdjascentes(T conteudo){
        Conjunto8<T> conjunto=new Conjunto8<T>();
        for(Entry<T,ListaAntiga<T>> entrada:grafo.conjunto()) conjunto.adiciona(entrada.getKey());
        conjunto.diferencaCom(grafo.pega(conteudo));
        return conjunto;
    }

    public ListaAntiga<T> pegaVertices(){
        ListaAntiga<T> vertices=new ListaAntiga<T>();
        for(Entry<T,ListaAntiga<T>> entrada:grafo.conjunto()) vertices.adiciona(entrada.getKey());
        return vertices;
    }

    public int tamanho(){
        return grafo.size();
    }

    @Override
    public String toString(){
        String s="";
        for(Map.Entry<T,ListaAntiga<T>> par:grafo.conjunto()) {
            s+=par.getKey().toString();
            s+="      ";
            s+=par.getValue().toString();
            s+="\n";
        }
        return s;
    }

    public Set<Map.Entry<T,ListaAntiga<T>>> conjunto(){
        return grafo.entrySet();
    }

    public void imprime(int tamanhoDaChave){
        System.out.printf("%-"+tamanhoDaChave+"s |   %s \n\n","VERTICE","VERTICES DE DESTINO");
        for(Map.Entry<T,ListaAntiga<T>> entrada:grafo.conjunto()) {
            T chave=entrada.getKey();
            ListaAntiga<T> lista=entrada.getValue();
            System.out.printf("%-"+tamanhoDaChave+"s |   %s \n",chave,lista.toString());
        }
    }
}
