package testes_PDF;

import org.junit.Test;

import PDF.PDF;

/**
 *
 * @author psdav
 */
public class PDFTest{

    public PDFTest(){
    }


    /**
     * Test of criaPDF method, of class PDF.
     */
    @Test
    public void testCriaPDF(){
        System.out.println("criaPDF");
        PDF pdf = new PDF("novo.pdf");
        pdf.criaPDF();
    }
}
