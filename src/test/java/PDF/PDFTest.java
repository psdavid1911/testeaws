package PDF;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author psdav
 */
public class PDFTest {
    
    public PDFTest() {
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
     * Test of criaPDF method, of class PDF.
     */
    @Test
    public void testCriaPDF() {
        System.out.println("criaPDF");
        PDF pdf = new PDF("novo.pdf");
        pdf.criaPDF();
    }
    
}
