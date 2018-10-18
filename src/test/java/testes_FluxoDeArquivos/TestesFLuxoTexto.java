package testes_FluxoDeArquivos;

import FluxoDeArquivos.FluxoDeTexto;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class TestesFLuxoTexto{

    @Test
    public void testEscreve2(){
        FluxoDeTexto es;
        es = new FluxoDeTexto("test/lixo/TesteFluxoDeTexto2.txt");
        ArrayList<String> linhas = new ArrayList<String>(Arrays.asList(
                "Linha 1", "Linha 2", "Linha 3"
        ));
        es.escreve(linhas);
        //es.apaga();
    }

    @Test
    public void testLe1(){
        FluxoDeTexto es;
        es = new FluxoDeTexto("test/lixo/TesteFluxoDeTexto.txt");
        ArrayList<String> linhas = es.le();
        System.out.println(linhas);
    }

    @Test
    public void testLe2(){
        FluxoDeTexto es;
        es = new FluxoDeTexto("test/lixo/TesteFluxoDeTexto2.txt");
        ArrayList<String> linhas = es.le();
        System.out.println(linhas);
    }
}
