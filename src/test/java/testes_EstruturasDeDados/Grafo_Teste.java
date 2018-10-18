package testes_EstruturasDeDados;

import EstruturasDeDados.Conjunto;
import EstruturasDeDados.Grafo;
import java.util.ArrayList;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Grafo_Teste{

    @Test
    public void teste_AdicionaAresta(){
        System.out.println("----------------------------------------------------------");
        System.out.println("Teste de adição de aresta");
        System.out.println("----------------------------------------------------------");
        Grafo<String> grafo = new Grafo<>();
        grafo.adicionaAresta("aresta1", "aresta2");
        grafo.adicionaAresta("aresta2", "aresta1");
        grafo.adicionaAresta("aresta3", "aresta2");
        grafo.adicionaAresta("aresta2", "aresta3");
        grafo.adicionaAresta("aresta2", "aresta4");
        grafo.adicionaAresta("aresta2", "aresta5");
        grafo.imprime(10);
        Conjunto<String> conjunto = grafo.pegaNaoAdjascentes("aresta3");
        System.out.println(conjunto.toString());
        //assertEquals("aresta1      [aresta2]\n" + "aresta2      []\n" +"", grafo.toString());
    }

    @Test
    public void teste_AdicionaVertice(){
        System.out.println("----------------------------------------------------------");
        System.out.println("Teste adição de vértice");
        System.out.println("----------------------------------------------------------");
        Grafo<String> grafo = new Grafo<>();
        grafo.imprime(10);
        assertEquals("", grafo.toString());
        grafo.adicionaVertice("Novo teste!");
        grafo.imprime(10);
        assertEquals("Novo teste!      []\n", grafo.toString());
    }

    @Test
    public void teste_AdjascentesAresta(){
        System.out.println("----------------------------------------------------------");
        System.out.println("Teste para recuperação de adjascentes");
        System.out.println("----------------------------------------------------------");
        Grafo<String> grafo = new Grafo<>();
        grafo.adicionaAresta("aresta1", "aresta2");
        grafo.adicionaAresta("aresta2", "aresta1");
        grafo.adicionaAresta("aresta3", "aresta2");
        grafo.adicionaAresta("aresta2", "aresta3");
        grafo.adicionaAresta("aresta2", "aresta4");
        grafo.adicionaAresta("aresta2", "aresta5");
        grafo.imprime(10);
        ArrayList<String> conjunto = grafo.adjascencias("aresta3");
        System.out.println(conjunto.toString());
        assertEquals("[aresta2]", conjunto.toString()); // teste automático
    }

    @Test
    public void teste_Existencia(){
        System.out.println("----------------------------------------------------------");
        System.out.println("Teste de existencia do grafo");
        System.out.println("----------------------------------------------------------");
        Grafo<String> grafo = new Grafo<>();
        grafo.adicionaAresta("aresta1", "aresta2");
        assertTrue(grafo.existeAresta("aresta1", "aresta2")); // teste automatico
        grafo.imprime(10);
        System.out.println("Existe vertice 1: " + grafo.existeVertice("aresta1"));
        System.out.println("Existe vertice 2: " + grafo.existeVertice("aresta2"));
        System.out.println("Existe vertice 3: " + grafo.existeVertice("aresta3"));
        System.out.println("Existe aresta 1 para 2: " + grafo.existeAresta("aresta1", "aresta2"));
        System.out.println("Existe aresta 2 para 1: " + grafo.existeAresta("aresta2", "aresta1"));
    }

    @Test
    public void teste_Laco(){
        System.out.println("----------------------------------------------------------");
        System.out.println("Teste para possibilidade de existencia de laço");
        System.out.println("----------------------------------------------------------");
        Grafo<String> grafo = new Grafo<>();
        grafo.adicionaAresta("1", "1");
        grafo.imprime(10);
    }

    @Test
    public void teste_Trivialidade(){
        System.out.println("----------------------------------------------------------");
        System.out.println("Prova que o grafo pode ser consituido de apenas um vértice");
        System.out.println("----------------------------------------------------------");
        Grafo<String> grafo = new Grafo<>();
        grafo.imprime(10); // imprime um grafo sem elementos
        grafo.adicionaVertice("Olá mundo!");
        grafo.imprime(10); // imprime um grafo trivial
        grafo.apaga("Olá mundo!"); // esvazia esse caso de uso
        grafo.apaga("Olá mundo!"); // mostra que funciona mesmo com expectativa de underflow
        grafo.imprime(10); // imprime um grafo sem elementos
    }
}
