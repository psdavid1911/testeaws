package testes_AnalisadorSintatico;
import AnalisadorSintatico.Parsing;
import AnalisadorSintatico.Separador;
import EstruturasDeDados.Lista;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Não são usadas maiúsculas nos testes
 *
 * @author david
 */
public class ParsingTestesFalha{

    Parsing analisador=new Parsing();

    @Test public void testeFalha001(){
        Lista<String> conversaoInicial=new Lista<String>();
        String original="casa a é bonita";
        System.out.printf("\n%-20s[%s]","Original:",original);
        for(String palavra:Separador.separa(original))
            conversaoInicial.add(analisador.lexico.get(palavra));
        assertEquals("[Agramatical]",new Parsing().configuraTesta("Período","Agramatical",conversaoInicial).toString());
        conversaoInicial.clear();
        System.out.println();
    }
}
