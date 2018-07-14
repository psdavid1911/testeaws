package matematica;

import EstruturasDeDados8.Lista8;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author david
 */
public class avulso{
    EstatisticaDescritiva e = new EstatisticaDescritiva();

    @Before
    public void setUp(){
    }

    @Test
    public void moda(){
        Lista8<Double> lista = new Lista8<Double>(Arrays.asList(1d, 2d, 3d, 3d, 4d, 4d));
        e.moda(lista);
    }
}
