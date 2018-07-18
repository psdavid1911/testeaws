package testes_PM;

import Definicoes.Print;
import PM.Leitor_de_agentes;
import org.junit.Test;

/**
 *
 * @author Ane
 */
public class Leitor_de_agentesTest {

   

    /**
     * Test of toString method, of class Leitor_de_agentes.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Leitor_de_agentes instance = new Leitor_de_agentes();
        String expResult = "Leitor_de_agentes{" + "agentes=" + "" + '}';
        String result = instance.toString();
        System.out.println(result);
        Print.println(result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
