import EstruturasDeDados.Dupla;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author psdav
 */
public class NewEmptyJUnitTest{

    @Test
    public void NewEmptyJUnitTest(){
        Dupla<Double> d1=new Dupla<Double>(1., 2.);
        Dupla<Double> d2=new Dupla<Double>(3., 4.);
        try{
            d1.menos(d2).imprime();
        }catch(Exception ex){
            Logger.getLogger(NewEmptyJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
