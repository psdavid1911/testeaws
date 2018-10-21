package testes_AnalisadorSintatico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import AnalisadorSintatico.Parsing;

/**
 * Não são usadas maiúsculas nos testes
 *
 * @author david
 */
public class ParsingTestesAcerta{

    String gramatica = "file:///C:\\Users\\psdav\\Documents\\NetBeansProjects\\testeaws\\src\\test\\java\\testes_AnalisadorSintatico\\gramatica.txt";
    String lexico = "file:///C:\\Users\\psdav\\Documents\\NetBeansProjects\\testeaws\\src\\test\\java\\testes_AnalisadorSintatico\\lexico.txt";
    public Parsing analisador = new Parsing(gramatica, lexico);

    @Test public void teste001(){
        String original = "eu estudo português às segundas-feiras";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste002(){
        String original = "eu estudo português";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste003(){
        String original = "eu estudo";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste004(){
        String original = "estudo";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste005(){
        String original = "os homens desejam paz";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste006(){
        String original = "eu trabalho como professor";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste007(){
        String original = "muitas crianças viram os pássaros";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste008(){
        String original = "o bom filho compreende o esforço dos pais";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste009(){
        String original = "joão escreveu uma bela redação";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste010(){
        String original = "o livro está esgotado";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste011(){
        String original = "esta manhã prometia chuva";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste012(){
        String original = "todos os alunos saíram";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste013(){
        String original = "alguns de nós não foram à festa";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste014(){
        String original = "os homens desejam a paz"; // bechara 38 edicao
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }

    @Test public void teste015(){
        String original = "ela não trabalha aos sábados"; // bechara 38 edicao
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Período", resultado);
    }
}
