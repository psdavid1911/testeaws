package testes_EstruturasDeDados;

import EstruturasDeDados.TabelaHash8;
import org.junit.Test;

public class tabelaHash{
    @Test
    public void testTabelaHash(){
        TabelaHash8<String, String> t = new TabelaHash8<String, String>();
        t.adiciona("1", "2");
        t.adicionaSomando("1", "3");
        System.out.println(t.toString()+" "+t.pega("1").getClass().toString());
    }
}
