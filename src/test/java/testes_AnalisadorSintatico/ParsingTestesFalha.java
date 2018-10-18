package testes_AnalisadorSintatico;

import AnalisadorSintatico.Parsing;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Não são usadas maiúsculas nos testes
 *
 * @author david
 */
public class ParsingTestesFalha{

    String gramatica = "file:///C:\\Users\\psdav\\Documents\\NetBeansProjects\\testeaws\\src\\test\\java\\testes_AnalisadorSintatico\\gramatica.txt";
    String lexico = "file:///C:\\Users\\psdav\\Documents\\NetBeansProjects\\testeaws\\src\\test\\java\\testes_AnalisadorSintatico\\lexico.txt";
    public Parsing analisador = new Parsing(gramatica, lexico);

    @Test public void testeFalha001(){
        String original = "casa a é bonita";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Agramatical", resultado);
    }

    @Test public void testeFalha002(){
        String original = "joão gosta de maçã comer";
        String resultado = analisador.testa("Período", "Agramatical", original);
        analisador.imprime();
        assertEquals("Agramatical", resultado);
    }
}
