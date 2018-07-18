package AnalisadorSintatico;
import EstruturasDeDados.Lista;
import FluxoDeArquivos.FluxoDeTexto;
import org.junit.Test;

public class TweakInverteArquivo{

    @Test public void teste(){
        Lista<String> nova=new Lista<String>();
        FluxoDeTexto manipulador=new FluxoDeTexto("lexico.txt");
        for(String linha:manipulador.le()){
            linha=Gramatica.consertaFormatacao(linha);
            String argumentos[]=linha.split("->");
            nova.add(linha=argumentos[1]+"->"+argumentos[0]);
        }
        manipulador.escreve(nova);
    }
}
