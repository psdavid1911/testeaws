package testes_EstruturasDeDados;

import EstruturasDeDados.Conjunto;
import EstruturasDeDados.Grafo;
import EstruturasDeDados.GrafoBaixoAcoplamento;
import EstruturasDeDados.Lista;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testes_Grafo{

    @Test
    public void arestaExiste(){
        System.out.println("arestaExiste");
        Grafo grafo=new Grafo();
        grafo.adicionaAresta("aresta1", "aresta2");
        System.out.println(grafo);
        assertTrue(grafo.existeAresta("aresta1", "aresta2"));
        imprime(Integer.toString(grafo.tamanho()));
    }

    @Test
    public void testeAdicionaAresta(){
        System.out.println("testeAdicionaAresta");
        GrafoBaixoAcoplamento<String> grafo=new GrafoBaixoAcoplamento<String>();
        grafo.adicionaAresta("aresta1", "aresta2");
        grafo.adicionaAresta("aresta2", "aresta1");
        grafo.adicionaAresta("aresta3", "aresta2");
        grafo.adicionaAresta("aresta2", "aresta3");
        grafo.adicionaAresta("aresta2", "aresta4");
        grafo.adicionaAresta("aresta2", "aresta5");
        imprime(grafo.toString());
        Conjunto<String> conjunto=grafo.pegaNaoAdjascentes("aresta3");
        System.out.println(conjunto);
        //assertEquals("aresta1      [aresta2]\n" + "aresta2      []\n" +"", grafo.toString());
    }

    @Test
    public void testeAdicionaVertice(){
        GrafoBaixoAcoplamento<String> grafo=new GrafoBaixoAcoplamento<String>();
        //imprime(grafo.toString());
        assertEquals("", grafo.toString());
        grafo.adicionaVertice("Novo teste!");
        //imprime(grafo.toString());
        assertEquals("Novo teste!      []\n", grafo.toString());
    }

    @Test
    public void testeAdjascentesAresta(){
        System.out.println("Teste adjascentes...\n\n");
        GrafoBaixoAcoplamento<String> grafo=new GrafoBaixoAcoplamento<String>();
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

    void imprime( String s ){
        System.out.println(s);
    }
}
