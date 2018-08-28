package testes_Internet;

import EstruturasDeDados.Lista;
import Internet.PaginaHTML;
import org.junit.Test;

public class PaginaHTMLTest{

    //@Test
    public void testPegaTxt(){
        System.out.println("pegaHTML");
        Lista<String> result=PaginaHTML.pegaURL("http://localhost:8080/arquivos/lexico.txt");
        System.out.println(result);
    }

    @Test
    public void testPegaTxtDoPC(){
        System.out.println("testPegaTxtDoPC");
        Lista<String> result=PaginaHTML.pegaURL("file:///C:/Users/psdav/Documents/NetBeansProjects/testeaws/src/main/webapp/arquivos/lexico.txt");
        System.out.println(result);
    }
}
