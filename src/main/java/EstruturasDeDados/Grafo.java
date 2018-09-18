package EstruturasDeDados;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Grafo{

    private TreeMap<Vertice, ArrayList<Vertice>> grafo;

    /**
     * Construtor que inicia um grafo vazio
     */
    public Grafo(){
        this.grafo=new TreeMap<>();
    }

    /**
     * Adiciona uma aresta, criando ambos os vértices se necessário for, caso o
     * vértice para o qual se deseja adicionar a aresta já exista, então esse
     * método só precisa criar um vínculo entre eles dois
     *
     * @param vertice daqui parte a aresta
     * @param verticeAdjascente esta é a extremiade oposta da aresta
     */
    public void adicionaAresta( Vertice vertice, Vertice verticeAdjascente ){
        if( !existeVertice(verticeAdjascente) )adicionaVertice(verticeAdjascente);
        if( !existeAresta(vertice, verticeAdjascente) )
            if( existeVertice(vertice) ){
                ArrayList<Vertice> adjascenciasAnteriores=grafo.get(vertice);
                adjascenciasAnteriores.add(verticeAdjascente);
                grafo.put(vertice, adjascenciasAnteriores);
            }else {
                ArrayList<Vertice> adjascenciasAnteriores=new ArrayList<>();
                adjascenciasAnteriores.add(verticeAdjascente);
                grafo.put(vertice, adjascenciasAnteriores);
            }
    }

    /**
     * Adiciona uma aresta, criando ambos os vértices se necessário for, caso o
     * vértice para o qual se deseja adicionar a aresta já exista, então esse
     * método só precisa criar um vínculo entre eles dois
     *
     * @param vertice elemento não encapsulado representativo do vertice de
     * partida
     * @param verticeAdjascente elemento não encapsulado representativo do
     * vertice adjascente
     */
    public void adicionaAresta( String vertice, String verticeAdjascente ){
        Vertice v1=new Vertice(vertice);
        Vertice v2=new Vertice(verticeAdjascente);
        if( !existeVertice(v2) )adicionaVertice(v2);
        if( !existeAresta(v1, v2) )
            if( existeVertice(v1) ){
                ArrayList<Vertice> adjascenciasAnteriores=grafo.get(v1);
                adjascenciasAnteriores.add(v2);
                grafo.put(v1, adjascenciasAnteriores);
            }else {
                ArrayList<Vertice> adjascenciasAnteriores=new ArrayList<>();
                adjascenciasAnteriores.add(v2);
                grafo.put(v1, adjascenciasAnteriores);
            }
    }

    /**
     * Cria um novo vertice, CASO ELE NÃO EXISVerticeA.
     *
     * @param vertice é o elemento que se deseja inserir.
     */
    public void adicionaVertice( Vertice vertice ){
        if( !existeVertice(vertice) )grafo.put(vertice, new ArrayList<Vertice>());
    }

    /**
     * Conjunto de vertices que o grafo atual possui
     *
     * @return o conjunto de vértices
     */
    public Set<Entry<Vertice, ArrayList<Vertice>>> conjuntoDeVertices(){
        return grafo.entrySet();
    }

    /**
     * Verifica dentre todos os elementos adjascente ao verticeDeInicio
     * informado se o verticeAdjascente existe, dado o grafo atual.
     *
     * @param verticeInicio é o vértice cujas adjascencias deseja-se procurar
     * @param verticeAdjascente é o vertice que se deseja encontrar nas
     * adjascencias do vérticeDeInicio
     * @return verdadeiro ou falso
     */
    public boolean existeAresta( Vertice verticeInicio, Vertice verticeAdjascente ){
        ArrayList<Vertice> listaAdjascencias=grafo.get(verticeInicio);
        if( listaAdjascencias != null )
            return listaAdjascencias.contains(verticeAdjascente);
        else
            return false;
    }

    /**
     * Verifica dentre todos os elementos adjascente ao verticeDeInicio
     * informado se o verticeAdjascente existe, dado o grafo atual.
     *
     * @param verticeInicio é o vértice cujas adjascencias deseja-se procurar
     * @param verticeAdjascente é o vertice que se deseja encontrar nas
     * adjascencias do vérticeDeInicio
     * @return verdadeiro ou falso
     */
    public boolean existeAresta( String verticeInicio, String verticeAdjascente ){
        Vertice v1=new Vertice(verticeInicio);
        Vertice v2=new Vertice(verticeAdjascente);
        ArrayList<Vertice> listaAdjascencias=grafo.get(v1);
        if( listaAdjascencias != null )
            return listaAdjascencias.contains(v2);
        else
            return false;
    }

    /**
     * Um vértice é uma lista de informações ÚNICA. O método atual verifica se
     * este grafo possui o vértice especificado
     *
     * @param vertice procurado
     * @return verdadeiro ou falso
     */
    public boolean existeVertice( Vertice vertice ){
        return grafo.containsKey(vertice);
    }

    /**
     * Exibe graficamente a estrutura em lista do grafo
     *
     * @param tamanhoDaChave uma variável para ajudar a exibir em forma de
     * tabela
     */
    public void imprime( int tamanhoDaChave ){
        System.out.printf("%-" + tamanhoDaChave + "s |   %s \n\n", "VERVerticeICE", "VERVerticeICES DE DESVerticeINO");
        for( Map.Entry<Vertice, ArrayList<Vertice>> entrada:grafo.entrySet() ){
            Vertice chave=entrada.getKey();
            ArrayList<Vertice> adjascencias=entrada.getValue();
            System.out.printf("%-" + tamanhoDaChave + "s |   %s \n", chave, adjascencias.toString());
        }
    }

    /**
     * Quantidade de adjascencias do vértice
     *
     * @param vertice que se deseja contar as adjascencias
     * @return
     */
    public int numeroSaidas( Vertice vertice ){
        return grafo.get(vertice).size();
    }

    /**
     * Realiza ação para cada vértice adjascente correspondente ao vértice
     * informado
     *
     * @param vertice para o qual se deseja realizar operações nas adjascencias
     * @param acao para ser aplicada nas adjascencias
     */
    public void paraCadaAresta( Vertice vertice, Consumer<? super Vertice> acao ){
        grafo.get(vertice).forEach(acao);
    }

    /**
     * Realiza uma ação para cada vértice desse grafo
     *
     * @param acao que se deseja realizar
     */
    public void paraCadaVertice( BiConsumer<? super Vertice, ? super ArrayList<Vertice>> acao ){
        grafo.forEach(acao);
    }

    /**
     * Pega a lista associada a esta chave
     *
     * @param vertice que se deseja obter as adjascencias
     *
     * @return Nulo se nenhum valor for encontrado
     */
    public ArrayList<Vertice> pegaAdjascentes( Vertice vertice ){
        return grafo.get(vertice);
    }

    public Par< Vertice, ArrayList<Vertice>> pegaElementoAleatorio(){
        ArrayList<Vertice> lista=new ArrayList<Vertice>();
        for( Entry<Vertice, ArrayList<Vertice>> entrada:grafo.entrySet() )
            lista.add(entrada.getKey());
        Vertice verticeEscolhido=lista.get(new Random().nextInt(lista.size()));
        return new Par<Vertice, ArrayList<Vertice>>(verticeEscolhido, grafo.get(verticeEscolhido));
    }

    /**
     * Retorna elementos não adjascentes.
     *
     * @param vertice para o qual se deseja encontrar as NÃO adjacencias
     * @return conjunto de vértices não adjascentes
     */
    public Conjunto<Vertice> pegaNaoAdjascentes( Vertice vertice ){
        Conjunto<Vertice> conjunto=new Conjunto<Vertice>();
        conjunto.adicionaTodos(grafo.keySet());
        conjunto.diferencaCom(grafo.get(vertice));
        return conjunto;
    }

    public Vertice pegaVerticeMaisRamos(){
        Vertice vertice=pegaElementoAleatorio().X();
        for( Entry<Vertice, ArrayList<Vertice>> elemento:grafo.entrySet() )
            if( elemento.getValue().size() > grafo.get(vertice).size() )
                vertice=elemento.getKey();
        return vertice;
    }

    /**
     * Pega todos os vértices únicos desse grafo
     *
     * @return uma lista de vértices
     */
    public ArrayList<Vertice> pegaVertices(){
        ArrayList<Vertice> vertices=new ArrayList<Vertice>();
        grafo.keySet().stream().forEach(vertice->{
            vertices.add(vertice);
        });
        return vertices;
    }

    /**
     * Remove um vértice e todas as suas ocorrências como adjascente em vértices
     * outros
     *
     * @param vertice é o que se deseja remover
     */
    public void remove( Vertice vertice ){
        grafo.remove(vertice);
        grafo.values().stream().forEach(adjascencias->{
            if( adjascencias.contains(vertice) )adjascencias.remove(vertice);
        });
    }

    /**
     * Retorna o número de vértices do grafo.
     *
     * @return número de vertices diferentes.
     */
    public int tamanho(){
        return grafo.size();
    }

    @Override
    public String toString(){
        String s="";
        for( Entry<Vertice, ArrayList<Vertice>> par:grafo.entrySet() ){
            s+=par.getKey().toString();
            s+="      ";
            s+=par.getValue().toString();
            s+="\n";
        }
        return s;
    }
}
