package AnalisadorSintatico;
import EstruturasDeDados.Lista;
import FluxoDeArquivos.FluxoDeTexto;
import org.junit.Test;

public class TweakInverteArquivo{

    String arquivo="lexico.txt";

    @Test public void teste(){
        Lista<String> nova=new Lista<String>();
        FluxoDeTexto manipulador=new FluxoDeTexto(arquivo);
        for(String linha:manipulador.le()) {
            linha=Gramatica.consertaFormatacao(linha);
            String argumentos[]=linha.split("->");
            nova.add(linha=argumentos[1]+"->"+argumentos[0]);
        }
        manipulador.escreve(nova);
    }
}
