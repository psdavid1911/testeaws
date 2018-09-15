package testes_FluxoDeArquivos;

import FluxoDeArquivos.FluxoBeans;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestesFluxoObjeto{

    FluxoBeans<Object> fo;

    public TestesFluxoObjeto(){
        fo=new FluxoBeans<Object>("teste");
    }

    @Before
    public void setUp(){
    }

    @Test
    public void leEscreve1(){
        String s="Isso é um teste";
        fo.escreve(s);
        s=null;
        s=(String)fo.le();
        assertEquals(s, "Isso é um teste");
        System.out.println(s);
    }

    @Test
    public void leEscreve2(){
        String s1="Isso é um teste";
        String s2="Isso também é um teste";
        String s3="Isso também é um teste 2";
        ArrayList<String> lista1=new ArrayList<String>(Arrays.asList(s1, s2, s3));
        ArrayList<String> lista2=new ArrayList<String>(Arrays.asList(s1, s2, s3));
        fo.escreve(lista1);
        lista1=null;
        lista1=(ArrayList<String>)fo.le();
        assertEquals(lista1, lista2);
        System.out.println(lista1);
    }
}
