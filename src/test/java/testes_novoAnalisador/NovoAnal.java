package testes_novoAnalisador;

import AnalisadorSintatico.Parsing;
import org.junit.Test;

public class NovoAnal{

    String gramatica="file:///C:/Users/psdav/Documents/NetBeansProjects/testeaws/src/test/java/analisador/nova.txt";
    public Parsing analisador=new Parsing(gramatica);

    @Test public void testeAnal(){
        analisador.imprime();
        analisador.testa("passa", "não passa", "passaa");
        analisador.imprime();
    }
}
