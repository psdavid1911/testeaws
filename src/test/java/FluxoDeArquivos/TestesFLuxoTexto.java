package FluxoDeArquivos;

import EstruturasDeDados.ListaAntiga;
import java.util.Arrays;
import org.junit.Test;

public class TestesFLuxoTexto{

    @Test
    public void testEscreve2(){
        FluxoDeTexto es;
        es=new FluxoDeTexto("test/lixo/TesteFluxoDeTexto2.txt");
        ListaAntiga<String> linhas=new ListaAntiga<String>(Arrays.asList(
                "Linha 1","Linha 2","Linha 3"
        ));
        es.escreve(linhas);
        //es.apaga();
    }

    @Test
    public void testLe1(){
        FluxoDeTexto es;
        es=new FluxoDeTexto("test/lixo/TesteFluxoDeTexto.txt");
        ListaAntiga<String> linhas=es.le();
        System.out.println(linhas);
    }

    @Test
    public void testLe2(){
        FluxoDeTexto es;
        es=new FluxoDeTexto("test/lixo/TesteFluxoDeTexto2.txt");
        ListaAntiga<String> linhas=es.le();
        System.out.println(linhas);
    }

}
