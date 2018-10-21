package testes_Internet;

import java.util.ArrayList;

import org.junit.Test;

import Internet.PaginaHTML;

public class PaginaHTMLTest{

    //@Test
    public void testPegaTxt(){
        System.out.println("pegaHTML");
        ArrayList<String> result = PaginaHTML.pegaURL("http://localhost:8080/arquivos/lexico.txt");
        System.out.println(result);
    }

    @Test
    public void testPegaTxtDoPC(){
        System.out.println("testPegaTxtDoPC");
        ArrayList<String> result = PaginaHTML.pegaURL("file:///C:/Users/psdav/Documents/NetBeansProjects/testeaws/src/main/webapp/arquivos/lexico.txt");
        System.out.println(result);
    }
}
