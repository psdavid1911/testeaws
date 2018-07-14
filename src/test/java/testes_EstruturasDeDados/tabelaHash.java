/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes_EstruturasDeDados;

import EstruturasDeDados8.TabelaHash8;
import org.junit.Test;

/**
 *
 * @author david
 */
public class tabelaHash{
    @Test
    public void testTabelaHash(){
        TabelaHash8<String, String> t = new TabelaHash8<String, String>();
        t.adiciona("1", "2");
        t.adicionaSomando("1", "3");
        System.out.println(t.toString()+" "+t.pega("1").getClass().toString());
    }
}
