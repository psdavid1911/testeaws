package testes_Internet;
import EstruturasDeDados.Lista;
import Internet.PaginaHTML;
import org.junit.Test;

public class PaginaHTMLTest{

    @Test
    public void testPegaTxt(){
        System.out.println("pegaHTML");
        String endereco="http://18.228.55.248/Arquivos/gramatica.txt";
        Lista<String> result=PaginaHTML.pegaURL(endereco);
        System.out.println(result);
    }
}
