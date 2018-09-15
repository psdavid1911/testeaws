package testes_EstruturasDeDados;

import EstruturasDeDados.Conjunto;
import EstruturasDeDados.Grafo;
import EstruturasDeDados.Lista;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GrafoTest{

    @Test
    public void arestaExiste(){
        Grafo<String> grafo=new Grafo<String>();
        grafo.adicionaAresta("aresta1", "aresta2");
        assertTrue(grafo.existeAresta("aresta1", "aresta2"));
        imprime(Integer.toString(grafo.tamanho()));
    }

    @Test
    public void testeAdicionaAresta(){
        Grafo<String> grafo=new Grafo<String>();
        grafo.adicionaAresta("aresta1", "aresta2");
        grafo.adicionaAresta("aresta2", "aresta1");
        grafo.adicionaAresta("aresta3", "aresta2");
        grafo.adicionaAresta("aresta2", "aresta3");
        grafo.adicionaAresta("aresta2", "aresta4");
        grafo.adicionaAresta("aresta2", "aresta5");
        imprime(grafo.toString());
        Conjunto<String> conjunto=grafo.pegaNaoAdjascentes("aresta3");
        System.out.println(conjunto.toString());
        //assertEquals("aresta1      [aresta2]\n" + "aresta2      []\n" +"", grafo.toString());
    }

    @Test
    public void testeAdjascentesAresta(){
        System.out.println("Teste adjascentes...\n\n");
        Grafo<String> grafo=new Grafo<String>();
        grafo.adicionaAresta("aresta1", "aresta2");
        grafo.adicionaAresta("aresta2", "aresta1");
        grafo.adicionaAresta("aresta3", "aresta2");
        grafo.adicionaAresta("aresta2", "aresta3");
        grafo.adicionaAresta("aresta2", "aresta4");
        grafo.adicionaAresta("aresta2", "aresta5");
        imprime(grafo.toString());
        Lista<String> conjunto=grafo.pegaAdjascentes("aresta3");
        System.out.println(conjunto.toString());
        //assertEquals("aresta1      [aresta2]\n" + "aresta2      []\n" +"", grafo.toString());
    }

    @Test
    public void testeAdicionaVertice(){
        Grafo<String> grafo=new Grafo<String>();
        //imprime(grafo.toString());
        assertEquals("", grafo.toString());
        grafo.adicionaVertice("Novo teste!");
        //imprime(grafo.toString());
        assertEquals("Novo teste!      []\n", grafo.toString());
    }

    void imprime( String s ){
        System.out.println(s);
    }
}
