package GeometriaAnalitica;

import org.junit.Test;
import static Definicoes.Print.println;

public class RetaTest{

    @Test
    public void testSomeMethod(){
        println("Questões para revisao: 1 - Teste inclinação da reta para os pontos");
        Reta r1=new Reta(new Ponto(6., 2.), new Ponto(3., 7.));
        r1.imprime();
        println("");
        Reta r2=new Reta(new Ponto(14., 7.), new Ponto(2., 1.));
        r2.imprime();
        println("");
        Reta r3=new Reta(new Ponto(-5., 3.), new Ponto(2., 1.));
        r3.imprime();
        println("");
    }
}
