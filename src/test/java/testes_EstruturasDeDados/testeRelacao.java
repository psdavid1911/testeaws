/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes_EstruturasDeDados;
import EstruturasDeDados8.Par8;
import EstruturasDeDados8.Relacao8;
import org.junit.Test;

/**
 *
 * @author david
 */
public class testeRelacao{

    @Test
    public void teste_relacao(){
        Relacao8<Integer,String> r=new Relacao8();
        r.adiciona(1,"ola");
        r.adiciona(2,"bem vindo");
        Relacao8<String,Integer> nova=r.inversa();
        for(Par8<String,Integer> entrada:nova) System.out.println(entrada.getX()+": "+entrada.getY());
    }
}
