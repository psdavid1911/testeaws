package testes_EstruturasDeDados;

import EstruturasDeDados.TabelaHash;
import org.junit.Test;

public class tabelaHash{

    @Test
    public void testTabelaHash(){
        TabelaHash<String, String> t=new TabelaHash<String, String>();
        t.adiciona("1", "2");
        t.adicionaSomando("1", "3");
        System.out.println(t.toString() + " " + t.pega("1").getClass().toString());
    }
}
