package testes_FluxoDeArquivos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import FluxoDeArquivos.FluxoBeans;

public class TestesFluxoObjeto{

    FluxoBeans<Object> fo;

    public TestesFluxoObjeto(){
        fo = new FluxoBeans<Object>("teste");
    }


    @Test
    public void leEscreve1(){
        String s = "Isso é um teste";
        fo.escreve(s);
        s = null;
        s = (String) fo.le();
        assertEquals(s, "Isso é um teste");
        System.out.println(s);
    }

    @SuppressWarnings("unchecked") @Test
    public void leEscreve2(){
        String s1 = "Isso é um teste";
        String s2 = "Isso também é um teste";
        String s3 = "Isso também é um teste 2";
        ArrayList<String> lista1 = new ArrayList<String>(Arrays.asList(s1, s2, s3));
        ArrayList<String> lista2 = new ArrayList<String>(Arrays.asList(s1, s2, s3));
        fo.escreve(lista1);
        lista1 = null;
        lista1 = (ArrayList<String>) fo.le();
        assertEquals(lista1, lista2);
        System.out.println(lista1);
    }
}
