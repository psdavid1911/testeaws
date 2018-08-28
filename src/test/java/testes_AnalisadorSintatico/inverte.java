package testes_AnalisadorSintatico;

import AnalisadorSintatico.Parsing;
import NovoAnalisador.ManipuladorGrafo;
import org.junit.Test;

/**
 * Não são usadas maiúsculas nos testes
 *
 * @author david
 */
public class inverte{

    String gramatica="file:///C:/Users/psdav/Documents/NetBeansProjects/testeaws/src/main/webapp/arquivos/gramatica.txt";
    public Parsing analisador=new Parsing(gramatica);
    String lexico="file:///C:/Users/psdav/Documents/NetBeansProjects/testeaws/src/main/webapp/arquivos/lexico.txt";
    ManipuladorGrafo lex=new ManipuladorGrafo(lexico);

    @Test public void teste000(){
        lex.inverteMembros();
    }
}
