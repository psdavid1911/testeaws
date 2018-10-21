package testes_Internet;

import org.junit.jupiter.api.Test;

import Internet.Codificador;

public class CodificadorTest{

    /**
     * Test of codifica method, of class Codificador.
     */
    @Test
    public void testCodifica(){
        Codificador codificador = new Codificador("newfile.txt");
        codificador.codifica();
    }
}
