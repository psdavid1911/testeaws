package testes_PM;

import EstruturasDeDados.Lista;
import PM.Escalacao;
import PM.Escalador;
import PM.Gerar;
import PM.Servico;
import Tempo.DataHora;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author psdav
 */
public class EscaladorTest {

    public EscaladorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of criaPosto method, of class Escalador.
     */
    @Test
    public void testCriarEscala() {
        System.out.println("criarEscala");
        Escalador escalador = new Escalador(new Lista(
                Gerar.agente("contato", Gerar.tipo_de_escala(4, 2), "david", 0, new Lista<Servico>(), "01/01/2018"),
                Gerar.agente("contato2", Gerar.tipo_de_escala(4, 2), "segundo", 0, new Lista<Servico>(), "01/01/2018")
        ));
        Lista<Escalacao> result = escalador.criaPosto("praia do futuro", new DataHora(7, 30), new DataHora(14, 0), 3);
        System.out.println(result.toString());
        //assertEquals(expResult, result);
    }

}
