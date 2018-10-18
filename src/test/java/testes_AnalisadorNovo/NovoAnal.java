package testes_AnalisadorNovo;

import AnalisadorSintatico.Parsing;
import org.junit.Test;

public class NovoAnal{

    String gramatica = "file:///C:\\Users\\psdav\\Documents\\NetBeansProjects\\testeaws\\src\\test\\java\\testes_AnalisadorNovo\\nova.txt";
    public Parsing analisador = new Parsing(gramatica);

    @Test public void testeAnal(){
        System.out.println("\n\n\n\n");
        analisador.imprime();
        String r1 = analisador.testa("passa", "não passa", "mara"); // quer encontrar a condição de acerto passa, esta perguntando se maria passa
        analisador.imprime();
        System.out.println("Resultado " + r1);
        System.out.println("\n\n\n\n");
        String r2 = analisador.testa("passa", "não passa", "maria");
        analisador.imprime();
        System.out.println("Resultado " + r2);
        System.out.println("\n\n\n\n");
        String r3 = analisador.testa("passa", "não passa", "filha de maria");
        analisador.imprime();
        System.out.println("Resultado " + r3);
        System.out.println("\n\n\n\n");
    }
}
