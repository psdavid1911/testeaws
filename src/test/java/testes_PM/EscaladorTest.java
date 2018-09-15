package testes_PM;

import EstruturasDeDados.Lista;
import PM.Escalacao;
import PM.Escalador;
import PM.Gerar;
import PM.Servico;
import Tempo.DataHora;
import org.junit.Test;

public class EscaladorTest{

    @Test
    public void testCriarEscala(){
        System.out.println("criarEscala");
        Escalador escalador=new Escalador(new Lista(
                Gerar.agente("contato", Gerar.tipo_de_escala(4, 2), "david", 0, new Lista<Servico>(), "01/01/2018"),
                Gerar.agente("contato2", Gerar.tipo_de_escala(4, 2), "segundo", 0, new Lista<Servico>(), "01/01/2018")
        ));
        Lista<Escalacao> result=escalador.criaPosto("praia do futuro", new DataHora(7, 30), new DataHora(14, 0), 3);
        System.out.println(result.toString());
        //assertEquals(expResult, result);
    }
}
