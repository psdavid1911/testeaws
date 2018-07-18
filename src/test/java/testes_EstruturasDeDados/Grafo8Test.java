package testes_EstruturasDeDados;

import EstruturasDeDados.Conjunto8;
import EstruturasDeDados.Grafo8;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Grafo8Test{
    @Test
    public void testeAdicionaVertice(){
        Grafo8<String> grafo = new Grafo8<String>();
        //imprime(grafo.toString());
        assertEquals("", grafo.toString());
        grafo.adicionaVertice("Novo teste!");
        //imprime(grafo.toString());
        assertEquals("Novo teste!      []\n", grafo.toString());
    }

    @Test
    public void testeAdicionaAresta(){
        Grafo8<String> grafo = new Grafo8<String>();
        grafo.adicionaAresta("aresta1", "aresta2");
        grafo.adicionaAresta("aresta2", "aresta1");
        grafo.adicionaAresta("aresta3", "aresta2");
        grafo.adicionaAresta("aresta2", "aresta3");
        grafo.adicionaAresta("aresta2", "aresta4");
        grafo.adicionaAresta("aresta2", "aresta5");
        imprime(grafo.toString());
        Conjunto8<String> conjunto = grafo.pegaNaoAdjascentes("aresta3");
        System.out.println(conjunto.toString());
        //assertEquals("aresta1      [aresta2]\n" + "aresta2      []\n" +"", grafo.toString());
    }

    void imprime(String s){
        System.out.println(s);
    }

    @Test
    public void arestaExiste(){
        Grafo8<String> grafo = new Grafo8<String>();
        grafo.adicionaAresta("aresta1", "aresta2");
        assertTrue(grafo.existeAresta("aresta1", "aresta2"));
        imprime(Integer.toString(grafo.tamanho()));
    }
}
