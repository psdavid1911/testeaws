import AnalisadorSintatico.Parsing;
import NovoAnalisador.ManipuladorGrafo;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author psdav
 */
public class NewEmptyJUnitTest{
    
    String gramatica="file:///C:/Users/psdav/Documents/NetBeansProjects/testeaws/src/main/webapp/arquivos/gramatica.txt";
    public Parsing analisador=new Parsing(gramatica);
    String lexico="file:///C:/Users/psdav/Documents/NetBeansProjects/testeaws/src/main/webapp/arquivos/lexico.txt";
    ManipuladorGrafo lex=new ManipuladorGrafo(lexico);
    
    @Test
    public void teste(){
        System.out.println(lex.toString());
    }
    
}
