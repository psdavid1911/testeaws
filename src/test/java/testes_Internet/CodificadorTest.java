package testes_Internet;

import Internet.Codificador;
import org.junit.Test;

public class CodificadorTest{

    /**
     * Test of codifica method, of class Codificador.
     */
    @Test
    public void testCodifica(){
        Codificador codificador=new Codificador("newfile.txt");
        codificador.codifica();
    }
}
