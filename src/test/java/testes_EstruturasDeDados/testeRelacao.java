package testes_EstruturasDeDados;

import EstruturasDeDados.Par;
import EstruturasDeDados.Relacao;
import org.junit.Test;

public class testeRelacao{

    @Test
    public void teste_relacao(){
        Relacao<Integer, String> r=new Relacao();
        r.adiciona(1, "ola");
        r.adiciona(2, "bem vindo");
        Relacao<String, Integer> nova=r.inversa();
        for( Par<String, Integer> entrada:nova )System.out.println(entrada.X() + ": " + entrada.Y());
    }
}
